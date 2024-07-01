package com.example.socialnetwork.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.socialnetwork.utils.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {


    @Provides
    @Singleton
    fun providePreference(application: Application): SharedPreferences =
        application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun providePreferenceManager(sharedPreference: SharedPreferences): PreferencesManager =
        PreferencesManager(sharedPreference)
}