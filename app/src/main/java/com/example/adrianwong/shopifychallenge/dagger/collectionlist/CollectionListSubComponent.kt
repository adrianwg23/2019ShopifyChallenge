package com.example.adrianwong.shopifychallenge.dagger.collectionlist

import com.example.adrianwong.shopifychallenge.collectionlist.CollectionListActivity
import dagger.Subcomponent

@CollectionListScope
@Subcomponent(modules = [CollectionListModule::class])
interface CollectionListSubComponent {
    fun inject(collectionListActivity: CollectionListActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): CollectionListSubComponent
    }
}