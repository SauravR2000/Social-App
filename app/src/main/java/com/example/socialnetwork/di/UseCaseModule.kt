//package com.example.socialnetwork.di
//
//import com.example.socialnetwork.domain.repository.AuthRepository
//import com.example.socialnetwork.domain.usecase.RegisterUserUseCase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//class UseCaseModule {
//
//    @Provides
//    @Singleton
//    fun provideRegisterUserUseCase(authRepository: AuthRepository): RegisterUserUseCase {
//        return RegisterUserUseCase(authRepository)
//    }
//}