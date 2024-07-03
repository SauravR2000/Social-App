package com.example.socialnetwork.di

import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.domain.repository.PostRepository
import com.example.socialnetwork.domain.usecase.GetAllPostsUseCase
import com.example.socialnetwork.domain.usecase.LoginUserUseCase
import com.example.socialnetwork.domain.usecase.RefreshTokenUseCase
import com.example.socialnetwork.domain.usecase.RegisterUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideRegisterUserUseCase(authRepository: AuthRepository): RegisterUserUseCase {
        return RegisterUserUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideRefreshTokenUseCase(authRepository: AuthRepository): RefreshTokenUseCase {
        return RefreshTokenUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideLoginUserUseCase(authRepository: AuthRepository): LoginUserUseCase {
        return LoginUserUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllPostsUseCase(postRepository: PostRepository): GetAllPostsUseCase {
        return GetAllPostsUseCase(postRepository)
    }
}