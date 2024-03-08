package com.kaushalvasava.app.spofitytestapp.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaushalvasava.app.spofitytestapp.data.local.repo.HistoryRepo
import com.kaushalvasava.app.spofitytestapp.data.remote.model.BaseResponse
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Albums
import com.kaushalvasava.app.spofitytestapp.data.remote.repo.SpotifyRepoImpl
import com.kaushalvasava.app.spofitytestapp.util.mappers.AlbumMapper
import com.kaushalvasava.app.spofitytestapp.util.mappers.to
import com.kaushalvasava.app.spofitytestapp.util.runCoroutineCatching
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repo: SpotifyRepoImpl,
    private val historyRepo: HistoryRepo,
) : ViewModel() {

    private val albumMapper: AlbumMapper by lazy {
        AlbumMapper()
    }

    private val _searchQueryFlow = MutableStateFlow<String>("taylor swift")
    val searchQueryFlow: StateFlow<String> = _searchQueryFlow
    private var _typeFlow = MutableStateFlow(Type.ALBUM)
    val typeFlow: StateFlow<Type> = _typeFlow
    private val _dataFlow =
        MutableStateFlow(
            BaseResponse(
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
        )
    val dataFlow: StateFlow<BaseResponse> =
        _dataFlow

    init {
        fetchStoredData()
        getSearchQueryResult(searchQueryFlow.value)
    }

    fun fetchStoredData() {
        viewModelScope.launch(Dispatchers.IO) {
            historyRepo.getAllAlbums().collectLatest {
                Log.d("TAG", "stored data ${it.size}")
                val d = albumMapper.to(it)
                val albums = Albums(
                    href = "",
                    limit = d.size,
                    next = "",
                    offset = null,
                    total = d.size,
                    items = d,
                    previous = null
                )
                _dataFlow.value = BaseResponse(
                    albums = albums,
                    artists = null,
                    audiobooks = null,
                    tracks = null,
                    playlists = null,
                    shows = null,
                    episodes = null
                )
            }
        }
    }

    fun getSearchQueryResult(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG", "getSearchQueryResult: $query and ${searchQueryFlow.value}")
            if (query != searchQueryFlow.value) {
                // debounce logic to do not call search api for every minor query changes
                delay(500L)
            }
            runCoroutineCatching({
                val data = repo.getQueryData(
                    query.lowercase(),
                    "album,artist,playlist,track,show,episode"
                )
                Log.d(
                    "TAG",
                    "getSearchQueryResult: episode ${data.episodes?.items?.size} show ${data.shows?.items?.size},  track ${data.tracks?.items?.size}"
                )
                _dataFlow.value = data
            }) {
                Log.d("TAG", "getToken: ${it.message}")
            }
        }
    }

    fun setQuery(query: String) {
        _searchQueryFlow.value = query
    }

    fun setType(type: Type) {
        _typeFlow.value = type
    }

    fun storeData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataFlow.value.albums?.items?.map {
                historyRepo.upsertAlbum(
                    albumMapper.from(it)
                )
            }
        }
    }
}