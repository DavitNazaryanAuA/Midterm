package com.aua.davitnazaryan.midtermapp.repository

import com.aua.davitnazaryan.midtermapp.api.RetrofitInstance

class UserRepository {
    suspend fun getUsers(size: Int = 10, included: List<String> = listOf("nat", "name", "email")) =
        RetrofitInstance.api.getUsers(size = size, included = included.joinToString().trim())
}