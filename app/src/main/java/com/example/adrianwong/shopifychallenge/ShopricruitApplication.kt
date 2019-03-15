package com.example.adrianwong.shopifychallenge

import android.app.Application
import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
import com.example.adrianwong.shopifychallenge.collectionlist.CollectionListActivity
import com.example.adrianwong.shopifychallenge.dagger.DaggerMainComponent
import com.example.adrianwong.shopifychallenge.dagger.MainComponent
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent

class ShopricruitApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var collectionListSubComponent: CollectionListSubComponent? = null
    private var collectionDetailsSubComponent: CollectionDetailsSubComponent? = null

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .applicationContext(applicationContext)
            .baseUrl(getString(R.string.base_url))
            .build()
    }

    fun createCollectionListSubComponent(collectionListActivity: CollectionListActivity): CollectionListSubComponent {
        collectionListSubComponent = mainComponent
            .createCollectionListSubcomponentBuilder()
            .activity(collectionListActivity)
            .build()
        return collectionListSubComponent!!
    }

    fun releaseCollectionListSubComponent() {
        collectionListSubComponent = null
    }

    fun createCollectionDetailsSubComponent(collectionDetailsActivity: CollectionDetailsActivity): CollectionDetailsSubComponent {
        collectionDetailsSubComponent = mainComponent
            .createCollectionDetailsSubcomponentBuilder()
            .activity(collectionDetailsActivity)
            .build()
        return collectionDetailsSubComponent!!
    }

    fun releaseCollectionDetailsSubComponent() {
        collectionDetailsSubComponent = null
    }
}