package com.example.adrianwong.shopifychallenge.api

import com.example.adrianwong.shopifychallenge.datamodels.Collects
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollections
import com.example.adrianwong.shopifychallenge.datamodels.ProductsResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopifyApiService {

    @GET("custom_collections.json")
    fun getCustomCollections(@Query("page") page: Int,
                             @Query("access_token") accessToken: String): Deferred<CustomCollections>

    @GET("collects.json")
    fun getCollectionDetails(@Query("collection_id") collectionId: Int,
                             @Query("page") page: Int,
                             @Query("access_token") accessToken: String): Deferred<Collects>

    @GET("products.json")
    fun getProducts(@Query("ids") ids: String,
                    @Query("page") page: Int,
                    @Query("access_token") accessToken: String): Deferred<ProductsResult>
}

class ApiConstants {
    companion object {
        const val ACCESS_TOKEN = "c32313df0d0ef512ca64d5b336a0d7c6"
    }
}