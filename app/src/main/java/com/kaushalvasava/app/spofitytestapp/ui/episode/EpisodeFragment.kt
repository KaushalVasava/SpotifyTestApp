package com.kaushalvasava.app.spofitytestapp.ui.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentEpisodeBinding
import com.kaushalvasava.app.spofitytestapp.util.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment : Fragment() {

    private var _binding: FragmentEpisodeBinding? = null
    private val binding
        get() = _binding!!
    private val args: EpisodeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEpisodeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val episode = args.episode
        (activity as AppCompatActivity).supportActionBar?.title = episode.name
        binding.txtDesc.text = episode.description
        binding.txtLanguage.text = episode.language
        binding.ivImage.setImage(episode.images.firstOrNull()?.url)
        binding.txtDate.text = episode.releaseDate
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}