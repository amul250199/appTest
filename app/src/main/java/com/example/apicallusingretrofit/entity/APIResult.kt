package com.example.apicallusingretrofit.entity

import com.example.retrofitrequestget.enum.APIErrorCode


sealed class APIResult<out T : Any> {
    data class Success<out T : Any>(val data: T, val message: Post?) : APIResult<T>()
    data class Failure(val code: APIErrorCode, val message: String? = null) : APIResult<Nothing>()
    object InProgress : APIResult<Nothing>()
}
