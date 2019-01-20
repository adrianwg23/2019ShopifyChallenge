package com.example.adrianwong.shopifychallenge.dagger.collectiondetails

import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
import dagger.Subcomponent

@CollectionDetailsScope
@Subcomponent(modules = [CollectionDetailsModule::class])
interface CollectionDetailsSubComponent {
    fun inject(collectionDetailsActivity: CollectionDetailsActivity)
}