package com.meeweel.data.impl

import com.meeweel.domain.models.LoadResult
import retrofit2.Response

object ResultMapper {

    fun <T> Response<out T>.toLoadResult(): LoadResult<T> {
        return when {
            this.isSuccessful -> LoadResult.Done(this.body())
            else -> LoadResult.Error(this.message())
        }
    }
}