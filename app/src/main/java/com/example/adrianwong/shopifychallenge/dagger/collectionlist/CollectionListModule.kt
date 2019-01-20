package com.example.adrianwong.shopifychallenge.dagger.collectionlist

import com.example.adrianwong.shopifychallenge.collectionlist.CollectionListActivity
import dagger.Module
import dagger.Provides

@Module
class CollectionListModule(private val collectionListActivity: CollectionListActivity) {

    @Provides
    @CollectionListScope
    fun providesCollectionListActivity() = collectionListActivity

}