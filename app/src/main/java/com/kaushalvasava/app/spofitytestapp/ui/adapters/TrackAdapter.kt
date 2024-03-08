package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.ItemTrackBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class TrackAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track, ItemTrackBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemTrackBinding {
        return ItemTrackBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemTrackBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.track.Track) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.album.images.firstOrNull()?.url?: item.previewUrl)
        binding.txtTotalTracks.text =
            binding.root.context.getString(R.string.track_number, item.trackNumber)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}
