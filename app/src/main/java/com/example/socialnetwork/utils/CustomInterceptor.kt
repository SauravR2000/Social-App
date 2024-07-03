package com.example.socialnetwork.utils

import androidx.hilt.navigation.compose.hiltViewModel
import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.constants.accessToken
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.refreshToken
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import com.example.socialnetwork.domain.repository.AuthRepository
import com.example.socialnetwork.domain.usecase.RefreshTokenUseCase
import com.example.socialnetwork.presentation.GlobalViewModel
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named


class CustomInterceptor @Inject constructor(
    private val preferencesManager: PreferencesManager,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {


        val originalRequest = chain.request()

        val requestBuilder = originalRequest.newBuilder()
            .header(
                "Authorization",
                "Bearer ${preferencesManager.getData(accessToken, "")}"
            )
        val request = requestBuilder.build()


        val response = chain.proceed(request)




        // Check if the response indicates that the access token is expired
        if (response.code == 401) {

            log("401 error")

            // Call the refresh token API to obtain a new access token
            val newAccessToken = runBlocking { callRefreshTokenAPI() }


            log("new access token = $accessToken")

            //store new accessToken
            preferencesManager.saveData(accessToken, newAccessToken)


            // Create a new request with the updated access token
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $newAccessToken")
                .build()

            response.close()


            return chain.proceed(newRequest)
        }
        return response
    }

    private suspend fun callRefreshTokenAPI(): String {


        val socialApiService = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(SocialApiService::class.java)



        val refreshToken = preferencesManager.getData(refreshToken, "")


        val refreshTokenRequestModel = RefreshTokenRequestModel(
            refreshToken = refreshToken
        )


        val response = socialApiService.refreshToken(refreshTokenRequestModel)


        log("new accesstokennnnnn ========  $response")
        log("new accesstokennnnnn data ========  ${response.body()?.data?.accessToken ?: ""}")

        return response.body()?.data?.accessToken ?: ""
    }
}