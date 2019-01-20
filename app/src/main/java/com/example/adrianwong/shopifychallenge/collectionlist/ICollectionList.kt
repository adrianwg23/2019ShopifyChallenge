package com.example.adrianwong.shopifychallenge.collectionlist

import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection

interface ICollectionList {

    interface View {
        fun setupAdapter()
        fun showLoadingView()
        fun hideLoadingView()
        fun setToolbarTitle()
        fun startCollectionDetailsActivity(customCollection: CustomCollection)
    }

    interface ViewModel {
        fun onStart()
        fun getCustomCollections()
    }
}