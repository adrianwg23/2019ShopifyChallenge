package com.example.adrianwong.shopifychallenge.dagger.modules

import android.content.Context
import com.example.adrianwong.shopifychallenge.dagger.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val applicationContext: Context) {

    @Provides
    @ApplicationScope
    fun providesApplicationContext() = applicationContext
}