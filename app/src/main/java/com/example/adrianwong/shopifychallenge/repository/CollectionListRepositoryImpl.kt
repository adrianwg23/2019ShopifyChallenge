package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.api.ShopifyApiService
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListScope
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import javax.inject.Inject

@CollectionListScope
class CollectionListRepositoryImpl @Inject constructor(private val shopifyApiService: ShopifyApiService)
    : ICollectionListRepository {

    override suspend fun getCollectionList(collectionId: Int, page: Int): Result<Exception, List<CustomCollection>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}