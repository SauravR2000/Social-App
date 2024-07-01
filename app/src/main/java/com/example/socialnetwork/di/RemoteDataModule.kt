package com.example.socialnetwork.di

import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.repository.dataSourceImpl.SocialRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(socialApiService: SocialApiService): SocialRemoteDataSource {
        return SocialRemoteDataSourceImpl(socialApiService)
    }


}