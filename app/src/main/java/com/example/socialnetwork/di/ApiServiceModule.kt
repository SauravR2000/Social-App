package com.example.socialnetwork.di

import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.constants.accessToken
import com.example.socialnetwork.data.api.SocialApiService
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
    fun provideOkHttpClient(preferencesManager: PreferencesManager): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header(
                        "Authorization",
                        "Bearer ${preferencesManager.getData(accessToken, "")}"
//                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTk4MzM1NDksImRhdGEiOnsiaWQiOiI2NjczYjRiMGU5M2Y5YmVmMjMxNWJkMGQiLCJ1c2VyTmFtZSI6ImJpYmVrIiwiZW1haWwiOiJiaWJla0BnbWFpbC5jb20ifSwiaWF0IjoxNzE5ODMwNTQ5fQ.AJXU4hOGputy2KJRgtA9ZAJM5PFn6Rq91663VZJWgSU"
                    )
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideSocialApiService(retrofit: Retrofit): SocialApiService {
        return retrofit.create(SocialApiService::class.java)
    }

}