package com.example.adrianwong.shopifychallenge.collectiondetails

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.adrianwong.shopifychallenge.R
import com.example.adrianwong.shopifychallenge.ShopricruitApplication
import com.example.adrianwong.shopifychallenge.collectionlist.CollectionListActivity.Companion.COLLECTION_EXTRA
import com.example.adrianwong.shopifychallenge.datamodels.CustomCollection
import com.example.adrianwong.shopifychallenge.datamodels.Result
import com.example.adrianwong.shopifychallenge.util.makeToast
import kotlinx.android.synthetic.main.activity_collection_details.*
import javax.inject.Inject

class CollectionDetailsActivity : AppCompatActivity(), ICollectionDetails.View {

    @Inject lateinit var collectionDetailsAdapter: CollectionDetailsAdapter
    @Inject lateinit var factory: CollectionDetailsViewModelFactory
    private lateinit var collectionDetailsViewModel: CollectionDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection_details)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupToolbar()

        val customCollection = intent?.extras?.getSerializable(COLLECTION_EXTRA) as? CustomCollection

        (application as ShopricruitApplication).createCollectionDetailsSubComponent().inject(this)
        setupAdapter()

        collectionDetailsViewModel = ViewModelProviders.of(this, factory).get(CollectionDetailsViewModel::class.java)
        collectionDetailsViewModel.onStart()

        if (customCollection != null) {
            setupCustomCollectionsCard(customCollection)
            showLoading()
            collectionDetailsViewModel.getProducts(customCollection)
        }

        collectionDetailsViewModel.productResult.observe(this, Observer {
            it?.let { result ->
                when (result) {
                    is Result.Value -> {
                        collectionDetailsAdapter.submitList(result.value)
                        hideLoading()
                    }
                    is Result.Error -> {
                        makeToast(getString(R.string.network_error))
                    }
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        (application as ShopricruitApplication).releaseCollectionDetailsSubComponent()
    }

    override fun setupAdapter() {
        contentDetailsRecyclerView.adapter = collectionDetailsAdapter
    }

    override fun showLoading() {
        collectionDetailsProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        collectionDetailsProgressBar.visibility = View.INVISIBLE
    }

    override fun setupToolbar() {
        setTitle(R.string.collection_detail)
    }

    override fun setupCustomCollectionsCard(customCollection: CustomCollection) {
        collectionDetailsTitle.text = customCollection.title
        collectionDetailsBody.text =
                if (customCollection.bodyHtml!!.isEmpty()) getString(R.string.missing_description) else customCollection.bodyHtml

        Glide.with(this)
            .load(customCollection.image?.src)
            .into(collectionDetailsImage)
    }
}
