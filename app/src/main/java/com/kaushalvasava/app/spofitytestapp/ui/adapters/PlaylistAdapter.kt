package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.ItemPlaylistBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class PlaylistAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist, ItemPlaylistBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemPlaylistBinding {
        return ItemPlaylistBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemPlaylistBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.playlist.Playlist) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.images.firstOrNull()?.url ?: "", R.drawable.ic_avatar)
        binding.txtTotalTracks.text =
            binding.root.context.getString(R.string.total_tracks, item.tracks.total)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}
