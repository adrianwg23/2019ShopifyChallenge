package com.example.adrianwong.shopifychallenge.datamodels

import com.google.gson.annotations.SerializedName

data class Collects(
    @SerializedName("collects")
    var collectionDetails: List<CollectionDetails>? = null
)

data class CollectionDetails(

    @SerializedName("id")
    var id: Long = -1,

    @SerializedName("collection_id")
    var collectionId: Long = -1,

    @SerializedName("product_id")
    var productId: Long = -1,

    @SerializedName("featured")
    var featured: Boolean = false
)