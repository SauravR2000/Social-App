package com.example.socialnetwork.di

import com.apollographql.apollo3.ApolloClient
import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.utils.LoggingApolloInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApolloServiceModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient
            .Builder()
            .serverUrl(BuildConfig.BASE_URL_GRAPHQL)
            .addInterceptor(LoggingApolloInterceptor())
            .build()
    }
}