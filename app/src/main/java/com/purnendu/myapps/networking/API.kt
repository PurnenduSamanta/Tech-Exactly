package com.purnendu.myapps.networking

import com.purnendu.myapps.networking.responseModel.AppListResponse
import retrofit2.Response
import retrofit2.http.*


interface API {
    @POST("api/v1/apps/list")
    suspend fun getApps( @Query("kid id") id: String): Response<AppListResponse>
}