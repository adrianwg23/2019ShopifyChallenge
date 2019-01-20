package com.example.adrianwong.shopifychallenge.collectionlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import com.example.adrianwong.shopifychallenge.repository.ICollectionListRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CollectionListViewModel(private val collectionListRepository: ICollectionListRepository) : ViewModel(),
    ICollectionList.ViewModel, CoroutineScope {

    val collectionResult = MutableLiveData<Result<Exception, List<CustomCollection>>>()

    private var pageNumber = 1

    private lateinit var jobTracker: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + jobTracker

    override fun onStart() {
        jobTracker = Job()
    }

    override fun getCustomCollections() {
        val result = collectionResult.value
        if (result is Result.Value) {
            if (result.value.isNullOrEmpty()) {
                requestCustomCollections()
            }
        } else if (result == null || result is Result.Error) {
            requestCustomCollections()
        }
    }

    private fun requestCustomCollections() = launch {
        val result = withContext(Dispatchers.IO) {
            collectionListRepository.getCollectionList(pageNumber)
        }

        collectionResult.value = result
    }

    override fun onCleared() {
        super.onCleared()
        jobTracker.cancel()
    }
}