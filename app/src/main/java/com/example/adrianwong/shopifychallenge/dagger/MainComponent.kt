package com.example.adrianwong.shopifychallenge.dagger

import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListModule
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent
import com.example.adrianwong.shopifychallenge.dagger.modules.AppModule
import com.example.adrianwong.shopifychallenge.dagger.modules.DataModule
import com.example.adrianwong.shopifychallenge.dagger.modules.NetworkModule
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class])
interface MainComponent {
    fun plus(collectionListModule: CollectionListModule): CollectionListSubComponent
    fun plus(collectionDetailsModule: CollectionDetailsModule): CollectionDetailsSubComponent
}