package com.kaushalvasava.app.spofitytestapp.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentSearchBinding
import com.kaushalvasava.app.spofitytestapp.ui.adapters.AlbumAdapter
import com.kaushalvasava.app.spofitytestapp.ui.adapters.ArtistAdapter
import com.kaushalvasava.app.spofitytestapp.ui.adapters.EpisodeAdapter
import com.kaushalvasava.app.spofitytestapp.ui.adapters.PlaylistAdapter
import com.kaushalvasava.app.spofitytestapp.ui.adapters.ShowAdapter
import com.kaushalvasava.app.spofitytestapp.ui.adapters.TrackAdapter
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.ALBUM
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.ARTIST
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.EPISODE
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.PLAYLIST
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.SHOW
import com.kaushalvasava.app.spofitytestapp.ui.search.Type.TRACK
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

private const val TAG = "TAG"

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()

    private val navController: NavController by lazy {
        findNavController()
    }
    private lateinit var artistAdapter: ArtistAdapter
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var playlistAdapter: PlaylistAdapter
    private lateinit var trackAdapter: TrackAdapter
    private lateinit var showAdapter: ShowAdapter
    private lateinit var episodeAdapter: EpisodeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        initAdapters()
        initRecyclerView()
        setSearchQuery()
        setClickListeners()
        setDataObserver()
    }

    private fun initAdapters() {
        artistAdapter = ArtistAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToArtistFragment(item)
            navController.navigate(action)
        }
        playlistAdapter = PlaylistAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToPlaylistFragment(item)
            navController.navigate(action)
        }
        albumAdapter = AlbumAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToAlbumFragment(item)
            navController.navigate(action)
        }
        trackAdapter = TrackAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToTrackFragment(item)
            navController.navigate(action)
        }
        showAdapter = ShowAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToShowFragment(item)
            navController.navigate(action)
        }
        episodeAdapter = EpisodeAdapter { item ->
            val action = SearchFragmentDirections.actionSearchFragmentToEpisodeFragment(item)
            navController.navigate(action)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = when (searchViewModel.typeFlow.value) {
                ALBUM -> {
                    albumAdapter
                }

                ARTIST -> {
                    artistAdapter
                }

                PLAYLIST -> {
                    playlistAdapter
                }

                TRACK -> {

                    trackAdapter
                }

                SHOW -> {
                    showAdapter
                }

                EPISODE -> {
                    episodeAdapter
                }
            }
        }
    }

    private fun setSearchQuery() {
        binding.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query.isNullOrEmpty().not())
                        searchViewModel.setQuery(query!!)
                    return false
                }

                override fun onQueryTextChange(query: String?): Boolean {

                    val tempQuery = query.takeUnless { it.isNullOrEmpty() }
                    val lastSearchQuery = searchViewModel.searchQueryFlow.value
                    if (tempQuery != null && lastSearchQuery != tempQuery) {
                        searchViewModel.getSearchQueryResult(tempQuery)
                        searchViewModel.setQuery(tempQuery)
                    }
                    return true
                }
            }
        )
    }

    private fun setUpType(type: Type) {
        showLoading(true)
        searchViewModel.setType(type)
        initRecyclerView()
    }

    private fun setClickListeners() {
        binding.chipAlbums.setOnClickListener {
            setUpType(ALBUM)
        }
        binding.chipArtists.setOnClickListener {
            setUpType(ARTIST)
        }
        binding.chipPlaylists.setOnClickListener {
            setUpType(PLAYLIST)
        }
        binding.chipTracks.setOnClickListener {
            setUpType(TRACK)
        }
        binding.chipShows.setOnClickListener {
            setUpType(SHOW)
        }
        binding.chipEpisodes.setOnClickListener {
            setUpType(EPISODE)
        }
    }

    private fun setDataObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.typeFlow.combine(searchViewModel.dataFlow) { t, data -> t to data }
                .collectLatest { combinedData ->
                    val type = combinedData.first
                    val data = combinedData.second
                    showLoading(false)
                    when (type) {
                        ALBUM -> {
                            data.albums?.items?.let { albums ->
                                albumAdapter.submitList(albums)
                            }
                        }

                        ARTIST -> {
                            data.artists?.items?.let { artists ->
                                artistAdapter.submitList(artists)
                            }
                        }

                        PLAYLIST -> {
                            data.playlists?.items?.let { playlists ->
                                playlistAdapter.submitList(playlists)
                            }
                        }

                        TRACK -> {
                            data.tracks?.items?.filterNotNull().apply {
                                trackAdapter.submitList(this)
                            }
                        }

                        SHOW -> {
                            data.shows?.items?.filterNotNull().apply {
                                showAdapter.submitList(this)
                            }
                        }

                        EPISODE -> {
                            data.episodes?.items?.filterNotNull().apply {
                                episodeAdapter.submitList(this)
                            }
                        }
                    }
                }
        }
    }


    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
        searchViewModel.storeData()
    }

    private fun showLoading(isVisible: Boolean) {
        binding.progressBar.isVisible = isVisible
        binding.recyclerView.isVisible = !isVisible
    }
}