package com.kaushalvasava.app.spofitytestapp.ui.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentArtistBinding
import com.kaushalvasava.app.spofitytestapp.util.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private var _binding: FragmentArtistBinding? = null
    private val binding
        get() = _binding!!

    private val args: ArtistFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentArtistBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val artist = args.artist
        (activity as AppCompatActivity).supportActionBar?.title = artist.name
        binding.txtFollowers.text = getString(
            R.string.followers_count,
            artist.followers.total
        )
        binding.ivImage.setImage(artist.images.firstOrNull()?.url)
        binding.txtPopularity.text = getString(R.string.popularity_count, artist.popularity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}