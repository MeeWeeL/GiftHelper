package com.meeweel.domain.models

sealed class LoadResult<out T> {
    data class Done<out T>(val result: T) : LoadResult<T>()
    data class Error(val message: String, val code: Int? = null) : LoadResult<Nothing>()

    companion object {

        fun createError(code: Int, message: String): LoadResult<Nothing> {
            return Error("Unsuccessful response; code: $code; message: $message")
        }
    }
}