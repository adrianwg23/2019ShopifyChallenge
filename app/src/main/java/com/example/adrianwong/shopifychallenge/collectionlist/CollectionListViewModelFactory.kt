package com.example.adrianwong.shopifychallenge.collectionlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adrianwong.shopifychallenge.dagger.collectionlist.CollectionListScope
import com.example.adrianwong.shopifychallenge.repository.ICollectionListRepository
import javax.inject.Inject

@CollectionListScope
class CollectionListViewModelFactory @Inject constructor(private val repository: ICollectionListRepository) :
        ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CollectionListViewModel::class.java)) {
            CollectionListViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}