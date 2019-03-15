package com.example.adrianwong.shopifychallenge.dagger

import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsModule
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsSubComponent
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListModule
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListSubComponent
import com.example.adrianwong.shopifychallenge.dagger.application.AppModule
import com.example.adrianwong.shopifychallenge.dagger.application.ApplicationScope
import com.example.adrianwong.shopifychallenge.dagger.application.DataModule
import com.example.adrianwong.shopifychallenge.dagger.application.NetworkModule
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class])
interface MainComponent {
    fun plus(collectionListModule: CollectionListModule): CollectionListSubComponent
    fun plus(collectionDetailsModule: CollectionDetailsModule): CollectionDetailsSubComponent
}