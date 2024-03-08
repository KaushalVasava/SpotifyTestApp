package com.kaushalvasava.app.spofitytestapp.ui.track

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentPlaylistBinding
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentTrackBinding
import com.kaushalvasava.app.spofitytestapp.ui.playlist.PlaylistFragmentArgs
import com.kaushalvasava.app.spofitytestapp.util.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackFragment : Fragment() {

    private var _binding: FragmentTrackBinding? = null
    private val binding
        get() = _binding!!
    private val args: TrackFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrackBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val track = args.track
        (activity as AppCompatActivity).supportActionBar?.title = track.name
        binding.txtName.text = track.album.name
        binding.ivImage.setImage(track.album.images.firstOrNull()?.url)
        binding.txtTotalSongs.text =
            getString(
                R.string.track_number,
                track.trackNumber
            )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}