package com.kaushalvasava.app.spofitytestapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

// Generic ListAdapter
abstract class GenericListAdapter<T, VB : ViewBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, GenericListAdapter.GenericViewHolder<VB>>(diffCallback) {

    // Create ViewBinding
    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    // Bind data to ViewHolder
    abstract fun bind(binding: VB, item: T)

    // ViewHolder with ViewBinding
    class GenericViewHolder<VB : ViewBinding>(val binding: VB) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = createBinding(inflater, parent)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<VB>, position: Int) {
        bind(holder.binding, getItem(position))
    }
}
