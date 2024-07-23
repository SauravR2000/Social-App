package com.example.socialnetwork.utils

import com.apollographql.apollo3.api.ApolloRequest
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.interceptor.ApolloInterceptor
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain
import com.example.socialnetwork.BuildConfig
import com.example.socialnetwork.constants.accessToken
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.refreshToken
import com.example.socialnetwork.data.api.SocialApiService
import com.example.socialnetwork.data.model.refreshTokenRequestModel.RefreshTokenRequestModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class CustomApiInterceptor @Inject constructor(
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
            .baseUrl(BuildConfig.BASE_URL_API)
            .build()
            .create(SocialApiService::class.java)


        val refreshToken = preferencesManager.getData(refreshToken, "")


        val refreshTokenRequestModel = RefreshTokenRequestModel(
            refreshToken = refreshToken
        )


        val response = socialApiService.refreshToken(refreshTokenRequestModel)


        log("new access token ========  $response")
        log("new access token data ========  ${response.body()?.data?.accessToken ?: ""}")

        return response.body()?.data?.accessToken ?: ""
    }
}


//class CustomApolloInterceptor
class LoggingApolloInterceptor : ApolloInterceptor {
    override fun <D : Operation.Data> intercept(
        request: ApolloRequest<D>,
        chain: ApolloInterceptorChain
    ): Flow<ApolloResponse<D>> {
        return chain.proceed(request).onEach { response ->
            log("Request = ${request}")
            log("Response = ${response}")
            log("Received response for ${request.operation.name()}: ${response.data}   error = ${response.errors} status ")
        }
    }
}