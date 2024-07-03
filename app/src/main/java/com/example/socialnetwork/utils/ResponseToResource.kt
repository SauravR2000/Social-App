package com.example.socialnetwork.utils

import android.util.Log
import com.example.socialnetwork.constants.log
import com.example.socialnetwork.constants.myTag
import com.example.socialnetwork.data.util.Resource
import org.json.JSONObject
import retrofit2.Response

fun <T> responseToResource(response: Response<T>): Resource<T> {
    if (response.isSuccessful) {
        response.body()?.let { result ->
            Log.i(myTag, "success message = ${result}")
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