package com.example.socialnetwork.di

import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.utils.CustomApiInterceptor
import com.example.socialnetwork.utils.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideAuthInterceptor(
        preferencesManager: PreferencesManager,
    ): CustomApiInterceptor {
        return CustomApiInterceptor(preferencesManager)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        customApiInterceptor: CustomApiInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                customApiInterceptor
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideSocialApiService(okHttpClient: OkHttpClient): SocialApiService {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL_API)
            .build()
            .create(SocialApiService::class.java)
    }


}