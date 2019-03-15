package com.example.adrianwong.shopifychallenge.dagger.application

import com.example.adrianwong.shopifychallenge.repository.CollectionDetailsRepositoryImpl
import com.example.adrianwong.shopifychallenge.repository.CollectionListRepositoryImpl
import com.example.adrianwong.shopifychallenge.repository.ICollectionDetailsRepository
import com.example.adrianwong.shopifychallenge.repository.ICollectionListRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    @ApplicationScope
    abstract fun bindICollectionListRepository(collectionListRepositoryImpl: CollectionListRepositoryImpl): ICollectionListRepository

    @Binds
    @ApplicationScope
    abstract fun bindICollectionDetailsRepository(collectionDetailsRepositoryImpl: CollectionDetailsRepositoryImpl): ICollectionDetailsRepository
}