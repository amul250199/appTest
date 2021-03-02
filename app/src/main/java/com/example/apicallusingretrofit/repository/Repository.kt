package com.example.apicallusingretrofit.repository

import android.content.Context
import com.example.apicallusingretrofit.R
import com.example.apicallusingretrofit.api.PostService
import com.example.apicallusingretrofit.entity.APIResult
import com.example.retrofitrequestget.enum.APIErrorCode
import com.example.retrofitrequestget.util.constant.Constant
import com.pavans.mvvmsample.util.helper.Helper

class Repository (val context: Context){
    suspend fun getUsers(listener: (APIResult<Array<String>>) -> Unit) {
        if (Helper.isNetworkAvailable(context)) {
            listener(APIResult.InProgress)

            val params = HashMap<String, String>()
            params["deviceType"] = Constant.DEVICE_TYPE

            val response = PostService.postInstance.getPost()
            if (response.isSuccessful) {

                listener(APIResult.Success(arrayOf(), response.body()))

            }

            else {
                listener(
                    APIResult.Failure(
                        APIErrorCode.NO_RESPONSE,
                        context.getString(R.string.error_msg)
                    )
                )

                return
            }
        } else {
            listener(
                APIResult.Failure(
                    APIErrorCode.NETWORK_ERROR,
                    context.getString(R.string.network_error_msg)
                )
            )

            return
        }
    }
}