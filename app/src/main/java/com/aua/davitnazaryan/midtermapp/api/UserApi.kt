package com.aua.davitnazaryan.midtermapp.api

import com.aua.davitnazaryan.midtermapp.model.UsersResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET
    suspend fun getUsers(
        @Query("results")
        size: Int,
        @Query("inc")
        included: String
    ): Response<UsersResult>
}