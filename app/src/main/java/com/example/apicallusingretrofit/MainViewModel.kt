package com.example.apicallusingretrofit

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel
import com.example.apicallusingretrofit.entity.APIResult
import com.example.apicallusingretrofit.entity.Post
import com.example.apicallusingretrofit.repository.Repository
import com.example.retrofitrequestget.enum.APIErrorCode
import com.example.retrofitrequestget.util.constant.Constant
import com.pavans.mvvmsample.util.helper.Helper
import retrofit2.Response

class MainViewModel(val application: Application): ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    suspend fun getPosts(listener: (APIResult<Array<String>>) -> Unit)
    {
        if (Helper.isNetworkAvailable(application)) {
            listener(APIResult.InProgress)

            val params = HashMap<String, String>()
            params["deviceType"] = Constant.DEVICE_TYPE

            val repository=Repository(application)

            val response = repository.getUsers(listener)


           /* if (response.isSuccessful) {

                listener(APIResult.Success(arrayOf(), response.body()))

            }

            else {
                listener(
                    APIResult.Failure(
                        APIErrorCode.NO_RESPONSE,
                        application.getString(R.string.error_msg)
                    )
                )

                return
            }
        } else {
            listener(
                APIResult.Failure(
                    APIErrorCode.NETWORK_ERROR,
                    application.getString(R.string.network_error_msg)
                )
            )

            return*/
        }
    }
}