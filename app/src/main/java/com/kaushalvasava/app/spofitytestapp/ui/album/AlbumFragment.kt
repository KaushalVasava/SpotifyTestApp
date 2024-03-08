package com.kaushalvasava.app.spofitytestapp.ui.album

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentAlbumBinding
import com.kaushalvasava.app.spofitytestapp.util.AppConstants
import com.kaushalvasava.app.spofitytestapp.util.setImage
import dagger.assisted.Assisted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class AlbumFragment : Fragment() {

    private var _binding: FragmentAlbumBinding? = null
    private val binding
        get() = _binding!!
    private val args: AlbumFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAlbumBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val album = args.album
        (activity as AppCompatActivity).supportActionBar?.title = album.name
        binding.txtDate.text = getString(R.string.release_date, album.releaseDate)
        binding.ivImage.setImage(album.images.first().url)
        binding.txtTotalTracks.text =
            getString(
                R.string.total_tracks,
                album.totalTracks
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}