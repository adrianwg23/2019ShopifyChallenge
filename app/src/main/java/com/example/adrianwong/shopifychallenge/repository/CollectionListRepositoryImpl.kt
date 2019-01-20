package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListScope
import javax.inject.Inject

@CollectionListScope
class CollectionListRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionListRepository {

}