package com.example.socialnetwork.data.model.genericModel

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T
)



inline fun <reified T> parseResponse(json: String): ApiResponse<T> {
    val gson = Gson()
    val type = object : TypeToken<ApiResponse<T>>() {}.type
    return gson.fromJson(json, type)
}
