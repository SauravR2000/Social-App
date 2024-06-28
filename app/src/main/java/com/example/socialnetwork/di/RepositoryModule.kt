//package com.example.socialnetwork.di
//
//import com.example.socialnetwork.data.repository.dataSource.SocialRemoteDataSource
//import com.example.socialnetwork.data.repository.repositoryImpl.AuthRepositoryImpl
//import com.example.socialnetwork.domain.repository.AuthRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//class RepositoryModule {
//
//    @Provides
//    @Singleton
//    fun provideAuthRepository(
//        remoteDataSource: SocialRemoteDataSource,
//    ): AuthRepository {
//        return AuthRepositoryImpl(remoteDataSource)
//    }
//}