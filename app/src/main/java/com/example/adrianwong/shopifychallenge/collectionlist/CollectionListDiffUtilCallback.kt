package com.example.adrianwong.shopifychallenge.collectionlist

import androidx.recyclerview.widget.DiffUtil
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection

class CollectionListDiffUtilCallback : DiffUtil.ItemCallback<CustomCollection>() {
    override fun areItemsTheSame(oldItem: CustomCollection, newItem: CustomCollection): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CustomCollection, newItem: CustomCollection): Boolean {
        return oldItem == newItem
    }
}