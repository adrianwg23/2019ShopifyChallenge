package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ApiConstants
import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.Product
import com.example.adrianwong.shopifychallenge.datamodels.Result
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionDetailsRepository {

    override suspend fun getCollectionDetails(collectionId: Long, page: Int): Result<Exception, List<CollectionDetails>> {
        return try {
            val collects = shopifyApiService.getCollects(collectionId, page, ApiConstants.ACCESS_TOKEN).await()
            Result.buildValue(collects.collectionDetails)
        } catch (e: Exception) {
            Result.buildError(e)
        }
    }

    override suspend fun getProducts(ids: String, page: Int): Result<Exception, List<Product>> {
        return try {
            val productsResult = shopifyApiService.getProducts(ids, page, ApiConstants.ACCESS_TOKEN).await()
            Result.buildValue(productsResult.products)
        } catch (e: Exception) {
            Result.buildError(e)
        }
    }

}