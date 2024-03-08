package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.databinding.ItemEpisodeBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class EpisodeAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode, ItemEpisodeBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemEpisodeBinding {
        return ItemEpisodeBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemEpisodeBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.episode.Episode) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.images.firstOrNull()?.url)
        binding.txtTotalFollowers.text ="1"
//            binding.root.context.getString(R.string.followers_count, item.)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}
