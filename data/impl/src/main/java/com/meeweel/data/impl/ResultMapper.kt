package com.meeweel.data.impl

import com.meeweel.domain.models.LoadResult
import retrofit2.Response

object ResultMapper {

    fun <T> Response<out T>.toLoadResult(): LoadResult<T> {
        return when {
            isSuccessful -> {
                body()?.let {
                    LoadResult.Done(it)
                } ?: LoadResult.Error(message())
            }

            else -> LoadResult.Error(message())
        }
    }

    inline fun <T, S> LoadResult<List<T>>.map(transformer: T.() -> S): LoadResult<List<S>> {
        return when (this) {
            is LoadResult.Done -> LoadResult.Done(result.map { it.transformer() })
            is LoadResult.Error -> LoadResult.Error(message, code)
        }
    }
}