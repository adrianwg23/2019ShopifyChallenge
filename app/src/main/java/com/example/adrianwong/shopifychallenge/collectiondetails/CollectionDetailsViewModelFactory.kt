package com.example.adrianwong.shopifychallenge.collectiondetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.adrianwong.shopifychallenge.dagger.collectiondetails.CollectionDetailsScope
import com.example.adrianwong.shopifychallenge.repository.ICollectionDetailsRepository
import javax.inject.Inject

@CollectionDetailsScope
class CollectionDetailsViewModelFactory @Inject constructor(private val repository: ICollectionDetailsRepository) :
        ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CollectionDetailsViewModel::class.java)) {
            CollectionDetailsViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}