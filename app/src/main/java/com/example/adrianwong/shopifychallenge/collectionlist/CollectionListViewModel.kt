package com.example.adrianwong.shopifychallenge.collectionlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import com.example.adrianwong.shopifychallenge.repository.ICollectionListRepository
import kotlinx.coroutines.*
import java.util.Collections.addAll
import kotlin.coroutines.CoroutineContext

class CollectionListViewModel(private val collectionListRepository: ICollectionListRepository) : ViewModel(),
    ICollectionList.ViewModel, CoroutineScope {

    val collectionList = mutableListOf<CustomCollection>()

    val collectionResult = MutableLiveData<Result<Exception, List<CustomCollection>>>()

    private var pageNumber = 1

    private lateinit var jobTracker: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + jobTracker

    override fun onStart() {
        jobTracker = Job()
    }

    override fun getCustomCollections() {
        if (collectionList.isNullOrEmpty()) {
            requestCustomCollections()
        }
    }

    private fun requestCustomCollections() = launch {
        val result = withContext(Dispatchers.IO) {
            collectionListRepository.getCollectionList(pageNumber++)
        }

        if (result is Result.Value) collectionList.addAll(result.value)
        collectionResult.value = result
    }

    override fun onCleared() {
        super.onCleared()
        jobTracker.cancel()
    }
}