package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ApiConstants
import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.application.ApplicationScope
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import javax.inject.Inject

@ApplicationScope
class CollectionListRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionListRepository {

    override suspend fun getCollectionList(page: Int): Result<Exception, List<CustomCollection>> {
        return try {
            val customCollections = shopifyApiService.getCustomCollections(page, ApiConstants.ACCESS_TOKEN).await()
            Result.buildValue(customCollections.customCollections)
        } catch (e: Exception) {
            Result.buildError(e)
        }
    }
}