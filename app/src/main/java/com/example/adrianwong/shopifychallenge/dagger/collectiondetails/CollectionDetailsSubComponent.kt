package com.example.adrianwong.shopifychallenge.dagger.collectiondetails

import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
import dagger.BindsInstance
import dagger.Subcomponent

@CollectionDetailsScope
@Subcomponent(modules = [CollectionDetailsModule::class])
interface CollectionDetailsSubComponent {
    fun inject(collectionDetailsActivity: CollectionDetailsActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): CollectionDetailsSubComponent

        @BindsInstance
        fun activity(collectionDetailsActivity: CollectionDetailsActivity): Builder
    }
}