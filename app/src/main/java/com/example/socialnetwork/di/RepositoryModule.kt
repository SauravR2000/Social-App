package com.example.socialnetwork.di

import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
import com.example.socialnetwork.data.repository.repositoryImpl.AuthRepositoryImpl
import com.example.socialnetwork.data.repository.repositoryImpl.PostRepositoryImpl
import com.example.socialnetwork.data.repository.repositoryImpl.UserRepositoryImpl
import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.domain.repository.PostRepository
import com.example.socialnetwork.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: SocialRemoteDataSource,
    ): AuthRepository {
        return AuthRepositoryImpl(remoteDataSource)
    }


    @Provides
    @Singleton
    fun providePostRepository(
        remoteDataSource: SocialRemoteDataSource,
    ): PostRepository {
        return PostRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteDataSource: SocialRemoteDataSource
    ): UserRepository {
        return UserRepositoryImpl(remoteDataSource)
    }
}