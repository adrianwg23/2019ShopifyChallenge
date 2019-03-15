package com.example.adrianwong.shopifychallenge

import android.app.Application
import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
import com.example.adrianwong.shopifychallenge.collectionlist.CollectionListActivity
import com.example.adrianwong.shopifychallenge.dagger.DaggerMainComponent
import com.example.adrianwong.shopifychallenge.dagger.MainComponent
import com.example.adrianwong.shopifychallenge.dagger.application.AppModule
import com.example.adrianwong.shopifychallenge.dagger.application.NetworkModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListModule
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent

class ShopricruitApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var collectionListSubComponent: CollectionListSubComponent? = null
    private var collectionDetailsSubComponent: CollectionDetailsSubComponent? = null

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(getString(R.string.base_url)))
            .build()
    }

    fun createCollectionListSubComponent(collectionListActivity: CollectionListActivity): CollectionListSubComponent {
        collectionListSubComponent = mainComponent.plus(CollectionListModule(collectionListActivity))
        return collectionListSubComponent!!
    }

    fun releaseCollectionListSubComponent() {
        collectionListSubComponent = null
    }

    fun createCollectionDetailsSubComponent(collectionDetailsActivity: CollectionDetailsActivity): CollectionDetailsSubComponent {
        collectionDetailsSubComponent = mainComponent.plus(CollectionDetailsModule(collectionDetailsActivity))
        return collectionDetailsSubComponent!!
    }

    fun releaseCollectionDetailsSubComponent() {
        collectionDetailsSubComponent = null
    }
}