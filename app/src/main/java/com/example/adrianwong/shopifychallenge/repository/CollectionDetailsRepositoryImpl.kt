package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.Product
import com.example.adrianwong.shopifychallenge.datamodels.Result
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionDetailsRepository {

    override suspend fun getCollectionDetails(collectionId: Int, page: Int): Result<Exception, List<CollectionDetails>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getProducts(ids: String, page: Int): Result<Exception, List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}