package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.kaushalvasava.app.spofitytestapp.R
import com.kaushalvasava.app.spofitytestapp.databinding.ItemShowBinding
import com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show
import com.kaushalvasava.app.spofitytestapp.util.ItemClickListener
import com.kaushalvasava.app.spofitytestapp.util.setImage

class ShowAdapter(private val itemClickListener: ItemClickListener<com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show>) :
    GenericListAdapter<com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show, ItemShowBinding>(
        diffCallback = object : DiffUtil.ItemCallback<com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show>() {
            override fun areItemsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show, newItem: com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ItemShowBinding {
        return ItemShowBinding.inflate(inflater, parent, false)
    }

    override fun bind(binding: ItemShowBinding, item: com.kaushalvasava.app.spofitytestapp.data.remote.model.show.Show) {
        binding.txtName.text = item.name
        binding.ivImage.setImage(item.images.firstOrNull()?.url)
        binding.txtTotalEpisodes.text =
            binding.root.context.getString(R.string.total_episodes, item.totalEpisodes)
        binding.root.setOnClickListener {
            itemClickListener.onItemClick(item)
        }
    }
}
