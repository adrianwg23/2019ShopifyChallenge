package com.example.adrianwong.shopifychallenge.datamodels

import com.google.gson.annotations.SerializedName

data class ProductsResult(
    @SerializedName("products")
    var products: List<Products>
)

data class Products(

    @SerializedName("id")
    var id: Long = -1,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("body_html")
    var bodyHtml: String? = null,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("tags")
    var tags: String? = null,

    @SerializedName("variants")
    var variants: List<Variants>? = null,

    @SerializedName("options")
    var options: List<Options>? = null,

    @SerializedName("image")
    var image: ProductImage? = null
)

data class Variants(

    @SerializedName("id")
    var id: Long = -1,

    @SerializedName("product_id")
    var productId: Long = -1,

    @SerializedName("price")
    var price: Double = 0.0,

    @SerializedName("updated_at")
    var updatedAt: String? = null,

    @SerializedName("inventory_quantity")
    var inventoryQuantity: Int = -1
)

data class Options(
    @SerializedName("values")
    var values: List<String>? = null
)

data class ProductImage(
    @SerializedName("image")
    var src: String? = null
)