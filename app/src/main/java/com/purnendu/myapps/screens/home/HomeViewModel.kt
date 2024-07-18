package com.purnendu.myapps.screens.home

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.purnendu.myapps.networking.responseModel.AppListResponse
import com.purnendu.myapps.utils.Response
import com.purnendu.myapps.networking.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel(private val application: Application) : AndroidViewModel(application) {


    private val _response: MutableState<Response<List<AppListResponse.Data.App>>> =
        mutableStateOf(Response.Empty())
    val response get() = _response


    fun getApps() {
        try {
            _response.value = Response.Loading()
            viewModelScope.launch(Dispatchers.IO) {

                val response =
                    Retrofit.retrofitInstance.getApps(id = Random.nextInt(1, 501).toString())

                if (response.isSuccessful && response.body() != null) {
                    val appsResponse = response.body() ?: return@launch

                    if (!appsResponse.success) {
                        _response.value = Response.Error(appsResponse.message)
                        return@launch
                    }

                    if (appsResponse.data.app_list.isEmpty()) {
                        _response.value = Response.Error("Empty List found")
                        return@launch
                    }

                    _response.value = Response.Success(appsResponse.data.app_list)


                } else if (response.errorBody() != null) {
                    throw Exception(response.message())
                } else {
                    throw Exception("Something went wrong")
                }

            }
        } catch (e: Exception) {
            throw Exception(e.localizedMessage)
        }

    }

}