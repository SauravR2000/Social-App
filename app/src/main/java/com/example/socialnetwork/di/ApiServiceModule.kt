//package com.example.socialnetwork.di
//
//import com.example.socialnetwork.BuildConfig
//import com.example.socialnetwork.data.api.SocialApiService
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//class ApiServiceModule {
//
//    @Provides
//    @Singleton
//    fun providesRetrofit(): Retrofit {
//        return Retrofit
//            .Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BuildConfig.BASE_URL)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideSocialApiService(retrofit: Retrofit): SocialApiService {
//        return retrofit.create(SocialApiService::class.java)
//    }
//}