package com.aua.davitnazaryan.midtermapp.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.aua.davitnazaryan.midtermapp.model.UsersResult
import com.aua.davitnazaryan.midtermapp.repository.UserRepository
import com.aua.davitnazaryan.midtermapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException


class UsersViewModel(
    app: Application,
    val usersRepository: UserRepository
): AndroidViewModel(app) {

    val users: MutableLiveData<Resource<UsersResult>> = MutableLiveData()
    var usersResult: UsersResult? = null

    fun getUsers() = viewModelScope.launch {
        getUsersRequest()
    }

    private suspend fun getUsersRequest() {
        users.postValue(Resource.Loading())
        try {
            val response = usersRepository.getUsers()
            users.postValue(handleUsersResult(response))
        } catch(t: Throwable) {
            when(t) {
                is IOException -> users.postValue(Resource.Error("Network Error"))
                else -> users.postValue(Resource.Error("Error getting users"))
            }
        }
    }

    private fun handleUsersResult(response: Response<UsersResult>): Resource<UsersResult> {
        if (!response.isSuccessful) return Resource.Error(response.message())
        response.body()?.let { responseBody ->
            if (usersResult == null) {
                usersResult = responseBody
            } else {
                usersResult!!.results.addAll(responseBody.results)
            }
        }
        return Resource.Success(usersResult!!)
    }
}