package com.example.adrianwong.shopifychallenge.collectiondetails

import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection

interface ICollectionDetails {

    interface View {
        fun setupCustomCollectionsCard(customCollection: CustomCollection)
        fun setupAdapter()
        fun showLoading()
        fun hideLoading()
        fun setupToolbar()
    }

    interface ViewModel {
    }
}