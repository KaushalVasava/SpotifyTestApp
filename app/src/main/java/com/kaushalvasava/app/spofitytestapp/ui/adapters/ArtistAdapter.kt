package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.ItemArtistBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class ArtistAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist, ItemArtistBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemArtistBinding {
        return ItemArtistBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemArtistBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.artist.Artist) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.images.firstOrNull()?.url)
        binding.txtTotalFollowers.text =
            binding.root.context.getString(R.string.followers_count, item.followers.total)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}
