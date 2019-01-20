package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.Products
import com.example.adrianwong.shopifychallenge.datamodels.Result
import java.lang.Exception

interface ICollectionDetailsRepository {
    suspend fun getCollectionDetails(page: Int): Result<Exception, List<CollectionDetails>>
    suspend fun getProducts(ids: String, page: Int): Result<Exception, List<Products>>
}