package com.example.adrianwong.shopifychallenge.dagger

import android.content.Context
import com.example.adrianwong.shopifychallenge.dagger.application.AppModule
import com.example.adrianwong.shopifychallenge.dagger.application.ApplicationScope
import com.example.adrianwong.shopifychallenge.dagger.application.DataModule
import com.example.adrianwong.shopifychallenge.dagger.application.NetworkModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class])
interface MainComponent {
    fun createCollectionListSubcomponentBuilder(): CollectionListSubComponent.Builder
    fun createCollectionDetailsSubcomponentBuilder(): CollectionDetailsSubComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): MainComponent

        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder
    }
}
