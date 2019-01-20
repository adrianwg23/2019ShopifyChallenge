package com.example.adrianwong.shopifychallenge.collectiondetails

import androidx.recyclerview.widget.DiffUtil
import com.example.adrianwong.shopifychallenge.datamodels.Products

class CollectionDetailsDiffUtilCallback : DiffUtil.ItemCallback<Products>() {
    override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
        return oldItem == newItem
    }
}