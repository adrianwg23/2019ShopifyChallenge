package com.example.adrianwong.shopifychallenge.collectiondetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adrianwong.shopifychallenge.R
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.datamodels.Product
import kotlinx.android.synthetic.main.collection_details_item.view.*
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsAdapter @Inject constructor() :
    ListAdapter<Product, CollectionDetailsAdapter.CollectionDetailsViewHolder>(CollectionDetailsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CollectionDetailsViewHolder(inflater.inflate(R.layout.collection_details_item, parent, false))
    }

    override fun onBindViewHolder(holder: CollectionDetailsViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }


    inner class CollectionDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(product: Product) {
            itemView.productTitle.text = product.title
            itemView.productBody.text = product.bodyHtml
            itemView.productVariants.text = "Variants: ${product.variants?.size}"

            val inventory = product.variants?.sumBy { it.inventoryQuantity }
            itemView.productInventory.text = "Inventory: $inventory"

            Glide.with(itemView.context)
                .load(product.image?.src)
                .into(itemView.productImage)
        }
    }
}