package com.example.adrianwong.shopifychallenge.repository

import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result

interface ICollectionListRepository {
    suspend fun getCollectionList(collectionId: Int, page: Int): Result<Exception, List<CustomCollection>>
}