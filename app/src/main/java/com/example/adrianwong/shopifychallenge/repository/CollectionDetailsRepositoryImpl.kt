package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionDetailsRepository {

}