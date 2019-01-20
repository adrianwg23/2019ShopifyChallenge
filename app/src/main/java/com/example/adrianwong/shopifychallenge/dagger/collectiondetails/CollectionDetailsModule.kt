package com.example.adrianwong.shopifychallenge.dagger.collectiondetails

import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
import dagger.Module
import dagger.Provides

@Module
class CollectionDetailsModule(private val collectionDetailsActivity: CollectionDetailsActivity) {

    @Provides
    @CollectionDetailsScope
    fun providesCollectionDetailsActivity() = collectionDetailsActivity

}