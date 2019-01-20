package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.Products
import com.example.adrianwong.shopifychallenge.datamodels.Result
import java.lang.Exception
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionDetailsRepository {

    override suspend fun getCollectionDetails(page: Int): Result<Exception, List<CollectionDetails>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProducts(ids: String, page: Int): Result<Exception, List<Products>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}