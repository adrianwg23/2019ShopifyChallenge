package com.example.adrianwong.shopifychallenge.dagger.application

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.repository.CollectionDetailsRepositoryImpl
import com.example.adrianwong.shopifychallenge.repository.CollectionListRepositoryImpl
import com.example.adrianwong.shopifychallenge.repository.ICollectionDetailsRepository
import com.example.adrianwong.shopifychallenge.repository.ICollectionListRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    @ApplicationScope
    fun providesCollectionListRepository(shopifyApiService: ShopifyApiService): ICollectionListRepository {
        return CollectionListRepositoryImpl(shopifyApiService)
    }

    @Provides
    @ApplicationScope
    fun providesCollectionDetailsRepository(shopifyApiService: ShopifyApiService): ICollectionDetailsRepository {
        return CollectionDetailsRepositoryImpl(shopifyApiService)
    }
}