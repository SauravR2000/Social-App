package com.example.socialnetwork.di

import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.constants.accessToken
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.domain.usecase.RefreshTokenUseCase
import com.example.socialnetwork.utils.CustomInterceptor
import com.example.socialnetwork.utils.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {

//    @Named("noInterceptor")
//    @Provides
//    @Singleton
//    fun provideSocialApiServiceWithNoInterceptor(): SocialApiService {
//        return Retrofit
//            .Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BuildConfig.BASE_URL)
//            .build()
//            .create(SocialApiService::class.java)
//    }


    @Provides
    @Singleton
    fun provideAuthInterceptor(
        preferencesManager: PreferencesManager,
    ): CustomInterceptor {
        return CustomInterceptor(preferencesManager)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        customInterceptor: CustomInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                customInterceptor
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
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(SocialApiService::class.java)
    }




}