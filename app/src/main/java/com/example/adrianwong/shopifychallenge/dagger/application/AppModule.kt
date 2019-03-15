package com.example.adrianwong.shopifychallenge.dagger.application

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val applicationContext: Context) {

    @Provides
    @ApplicationScope
    fun providesApplicationContext() = applicationContext
}