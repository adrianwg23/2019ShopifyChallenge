package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.Product
import com.example.adrianwong.shopifychallenge.datamodels.Result

interface ICollectionDetailsRepository {
    suspend fun getCollectionDetails(collectionId: Int, page: Int): Result<Exception, List<CollectionDetails>>
    suspend fun getProducts(ids: String, page: Int): Result<Exception, List<Product>>
}