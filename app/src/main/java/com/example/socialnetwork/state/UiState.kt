package com.example.socialnetwork.state

open class UiState<T> {
    class INITIAL<T> : UiState<T>()
    class LOADING<T> : UiState<T>()
    data class SUCCESS<T>(val data: T) : UiState<T>()
    data class ERROR<T>(val error: Any) : UiState<T>()
}