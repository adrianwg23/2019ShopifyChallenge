package com.example.adrianwong.shopifychallenge.collectiondetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adrianwong.shopifychallenge.datamodels.CollectionDetails
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Product
import com.example.adrianwong.shopifychallenge.datamodels.Result
import com.example.adrianwong.shopifychallenge.repository.ICollectionDetailsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CollectionDetailsViewModel(private val collectionDetailsRepository: ICollectionDetailsRepository) : ViewModel(),
    ICollectionDetails.ViewModel, CoroutineScope {

    val productResult = MutableLiveData<Result<Exception, List<Product>>>()

    private var pageNumber = 1

    private lateinit var jobTracker: Job

    override val coroutineContext: CoroutineContext
        get() = jobTracker + Dispatchers.Main

    override fun onStart() {
        jobTracker = Job()
    }

    override fun getProducts(customCollection: CustomCollection) {
        val result = productResult.value
        if (result is Result.Value) {
            if (result.value.isNullOrEmpty()) {
                requestProducts(customCollection)
            }
        } else if (result is Result.Error || result == null) {
            requestProducts(customCollection)
        }
    }

    private fun requestProducts(customCollection: CustomCollection) = launch {
        val collectionDetailsResult = withContext(Dispatchers.IO) {
            collectionDetailsRepository.getCollectionDetails(customCollection.id, pageNumber)
        }

        if (collectionDetailsResult is Result.Value<*>) {
            val collectionDetails = collectionDetailsResult.value as List<CollectionDetails>
            val productIds = collectionDetails
                .map { it.productId.toString() }
                .joinToString(",") { it }

            val productsResult = withContext(Dispatchers.IO) {
                collectionDetailsRepository.getProducts(productIds, pageNumber)
            }

            productResult.value = productsResult
        } else if (collectionDetailsResult is Result.Error) {
            val error = collectionDetailsResult.error
            productResult.value = Result.buildError(error)
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobTracker.cancel()
    }
}