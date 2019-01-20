package com.example.adrianwong.shopifychallenge.datamodels

import com.google.gson.annotations.SerializedName

data class CustomCollections(
    @SerializedName("custom_collections")
    var customCollections: List<CustomCollection>
)

data class CustomCollection(

    @SerializedName("id")
    var id: Long = -1,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("body_html")
    var bodyHtml: String? = null,

    @SerializedName("sort_order")
    var sortOrder: String? = null,

    @SerializedName("image")
    var image: CustomCollectionImage? = null
)

data class CustomCollectionImage(
    @SerializedName("src")
    var src: String? = null
)