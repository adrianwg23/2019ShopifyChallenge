package com.example.adrianwong.shopifychallenge.collectiondetails

import androidx.recyclerview.widget.DiffUtil
import com.example.adrianwong.shopifychallenge.datamodels.Product

class CollectionDetailsDiffUtilCallback : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}