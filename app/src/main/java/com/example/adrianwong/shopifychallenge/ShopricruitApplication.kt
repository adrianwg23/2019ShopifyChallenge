package com.example.adrianwong.shopifychallenge

import android.app.Application
import com.example.adrianwong.shopifychallenge.dagger.DaggerMainComponent
import com.example.adrianwong.shopifychallenge.dagger.MainComponent
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListModule
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent
import com.example.adrianwong.shopifychallenge.dagger.modules.AppModule
import com.example.adrianwong.shopifychallenge.dagger.modules.DataModule
import com.example.adrianwong.shopifychallenge.dagger.modules.NetworkModule

class ShopricruitApplication : Application() {

    private lateinit var mainComponent: MainComponent
    private var collectionListSubComponent: CollectionListSubComponent? = null
    private var collectionDetailsSubComponent: CollectionDetailsSubComponent? = null

    override fun onCreate() {
        super.onCreate()

        mainComponent = DaggerMainComponent.builder()
            .appModule(AppModule(applicationContext))
            .dataModule(DataModule())
            .networkModule(NetworkModule(getString(R.string.base_url)))
            .build()
    }

    fun createCollectionListSubComponent(): CollectionListSubComponent {
        collectionListSubComponent = mainComponent.plus(CollectionListModule())
        return collectionListSubComponent!!
    }

    fun releaseCollectionListSubComponent() {
        collectionListSubComponent = null
    }

    fun createCollectionDetailsSubComponent(): CollectionDetailsSubComponent {
        collectionDetailsSubComponent = mainComponent.plus(CollectionDetailsModule())
        return collectionDetailsSubComponent!!
    }

    fun releaseCollectionDetailsSubComponent() {
        collectionDetailsSubComponent = null
    }
}