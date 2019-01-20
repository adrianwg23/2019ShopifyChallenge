package com.example.adrianwong.shopifychallenge.collectionlist

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.adrianwong.shopifychallenge.R
import com.example.adrianwong.shopifychallenge.ShopricruitApplication
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import com.example.adrianwong.shopifychallenge.util.makeToast
import kotlinx.android.synthetic.main.activity_collection_list.*
import javax.inject.Inject

class CollectionListActivity : AppCompatActivity(), ICollectionList.View {

    @Inject lateinit var collectionListAdapter: CollectionListAdapter
    @Inject lateinit var factory: CollectionListViewModelFactory
    private lateinit var collectionListViewModel: CollectionListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection_list)
        setToolbarTitle()

        (application as ShopricruitApplication).createCollectionListSubComponent(this).inject(this)
        setupAdapter()

        collectionListViewModel = ViewModelProviders.of(this, factory).get(CollectionListViewModel::class.java)
        collectionListViewModel.onStart()

        showLoadingView()
        collectionListViewModel.getCustomCollections()

        collectionListViewModel.collectionResult.observe(this, Observer {
            it?.let { result ->
                when (result) {
                    is Result.Value -> {
                        collectionListAdapter.submitList(collectionListViewModel.collectionList)
                        hideLoadingView()
                    }
                    is Result.Error -> makeToast("Failed to fetch data")
                }
            }
        })

    }

    override fun setupAdapter() {
        collectionListAdapter.onItemClick = {
            startCollectionDetailsActivity(it)
        }
        contentListRecyclerView.layoutManager = GridLayoutManager(this, 2)
        contentListRecyclerView.adapter = collectionListAdapter
    }

    override fun showLoadingView() {
        contentListProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        contentListProgressBar.visibility = View.GONE
    }

    override fun setToolbarTitle() {
        setTitle(R.string.collection_list)
    }

    override fun startCollectionDetailsActivity(customCollection: CustomCollection) {
    }
}
