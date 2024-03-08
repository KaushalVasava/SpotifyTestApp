package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.ItemAlbumBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class AlbumAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album, ItemAlbumBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemAlbumBinding {
        return ItemAlbumBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemAlbumBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.album.Album) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.images.firstOrNull()?.url)
        binding.txtTotalTracks.text =
            binding.root.context.getString(R.string.total_tracks, item.totalTracks)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}