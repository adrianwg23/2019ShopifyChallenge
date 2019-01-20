package com.example.adrianwong.shopifychallenge.collectiondetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.datamodels.Products
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsAdapter @Inject constructor() :
    ListAdapter<Products, CollectionDetailsAdapter.CollectionDetailsViewHolder>(CollectionDetailsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionDetailsViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CollectionDetailsViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class CollectionDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}