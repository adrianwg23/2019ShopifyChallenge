package com.example.adrianwong.shopifychallenge.collectionlist

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.adrianwong.shopifychallenge.R
import com.example.adrianwong.shopifychallenge.ShopricruitApplication
import com.example.adrianwong.shopifychallenge.collectiondetails.CollectionDetailsActivity
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
                        collectionListAdapter.submitList(result.value)
                        hideLoadingView()
                    }
                    is Result.Error -> makeToast(getString(R.string.network_error))
                }
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        (application as ShopricruitApplication).releaseCollectionListSubComponent()
    }

    override fun setupAdapter() {
        collectionListAdapter.onItemClick = {
            startCollectionDetailsActivity(it)
        }
        contentListRecyclerView.layoutManager = GridLayoutManager(this, 2)
        contentListRecyclerView.adapter = collectionListAdapter
    }

    override fun showLoadingView() {
        collectionListProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        collectionListProgressBar.visibility = View.GONE
    }

    override fun setToolbarTitle() {
        setTitle(R.string.collection_list)
    }

    override fun startCollectionDetailsActivity(customCollection: CustomCollection) {
        val intent = Intent(this, CollectionDetailsActivity::class.java)
        intent.putExtra(COLLECTION_EXTRA, customCollection)
        startActivity(intent)
    }

    companion object {
        const val COLLECTION_EXTRA = "collection_extra"
    }
}