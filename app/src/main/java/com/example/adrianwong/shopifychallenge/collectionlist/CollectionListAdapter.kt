package com.example.adrianwong.shopifychallenge.collectionlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adrianwong.shopifychallenge.R
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListScope
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import kotlinx.android.synthetic.main.collection_list_item.view.*
import javax.inject.Inject

@CollectionListScope
class CollectionListAdapter @Inject constructor() :
    ListAdapter<CustomCollection, CollectionListAdapter.CustomCollectionViewHolder>(CollectionListDiffUtilCallback()) {

    var onItemClick: ((CustomCollection) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCollectionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CustomCollectionViewHolder(inflater.inflate(R.layout.collection_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: CustomCollectionViewHolder, position: Int) {
        val customCollection = getItem(position)
        holder.bind(customCollection)
    }

    inner class CustomCollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(customCollection: CustomCollection) {
            itemView.customCollectionTitle.text = customCollection.title

            Glide.with(itemView.context)
                .load(customCollection.image?.src)
                .into(itemView.customCollectionImage)

            itemView.setOnClickListener { onItemClick?.invoke(customCollection) }
        }
    }
}