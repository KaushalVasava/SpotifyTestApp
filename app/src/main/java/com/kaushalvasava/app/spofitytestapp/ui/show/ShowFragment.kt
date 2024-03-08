package com.kaushalvasava.app.spofitytestapp.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.FragmentShowBinding
import com.kaushalvasava.app.spofitytestapp.util.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null
    private val binding
        get() = _binding!!
    private val args: ShowFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val show = args.show
        (activity as AppCompatActivity).supportActionBar?.title = show.name
        binding.txtDesc.text = show.description
        binding.txtPublisher.text = show.publisher
        binding.ivImage.setImage(show.images.firstOrNull()?.url)
        binding.txtTotalSongs.text =
            getString(
                R.string.total_episodes,
                show.totalEpisodes
            )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}