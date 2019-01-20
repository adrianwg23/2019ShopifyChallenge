package com.example.adrianwong.shopifychallenge.collectionlist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListScope
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import javax.inject.Inject

@CollectionListScope
class CollectionListAdapter @Inject constructor() :
    ListAdapter<CustomCollection, CollectionListAdapter.CustomCollectionViewHolder>(CollectionListDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCollectionViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CustomCollectionViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CustomCollectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}