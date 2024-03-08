package com.kaushalvasava.app.spofitytestapp.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentPlaylistBinding
import com.kaushalvasava.app.spofitytestapp.util.setImage

class PlaylistFragment : Fragment() {

    private var _binding: FragmentPlaylistBinding? = null
    private val binding
        get() = _binding!!
    private val args: PlaylistFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPlaylistBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val playlist = args.playlist
        (activity as AppCompatActivity).supportActionBar?.title = playlist.name
        binding.txtName.text = playlist.owner.displayName
        binding.ivImage.setImage(playlist.images.firstOrNull()?.url)
        binding.txtTotalSongs.text =
            getString(
                R.string.total_tracks,
                playlist.tracks.total
            )
        binding.txtDesc.text = playlist.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}