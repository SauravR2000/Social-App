package com.example.socialnetwork.utils

import android.util.Log
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.data.util.Resource
import org.json.JSONObject
import retrofit2.Response

fun <T> responseToResource(response: Response<T>): Resource<T> {
    if (response.isSuccessful) {
        response.body()?.let { result ->
            Log.i(myTag, "success message = $result")
            return Resource.Success(result)
        }
    }

    val errorBody = response.errorBody()?.string() ?: ""

    log("error body message = ${errorBody}")

    val jsonObj = try {
        JSONObject(errorBody)
    } catch (e: Exception) {
        Log.e(myTag, "Error parsing error body", e)
        null
    }
    var errorMessage: String? = null

    errorMessage = jsonObj?.optString("errors")

    if (errorMessage?.isEmpty() ?: true) {
        errorMessage = jsonObj?.optString("message")
    }

    Log.i(myTag, "error = $errorMessage")

    return Resource.Error(
        errorMessage ?: "Something Went Wrong"
    )
}


fun <T : Operation.Data> apolloResponseToResource(response: ApolloResponse<T>): Resource<T> {

    log("responseeee ==== data == ${response.data}  error = ${response.errors} has error = ${response.hasErrors()} ${response}  ")

response

    return if (response.hasErrors()) {
        log("error = ${response.errors}")

        Resource.Error(response.errors?.firstOrNull()?.message ?: "Unknown error")
    } else {

        log("hereee = ${response.data} ${response.errors}")

        Resource.Success(response.data!!)
    }


}