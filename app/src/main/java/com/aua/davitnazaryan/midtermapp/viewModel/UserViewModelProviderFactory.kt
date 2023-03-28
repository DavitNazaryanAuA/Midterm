package com.aua.davitnazaryan.midtermapp.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aua.davitnazaryan.midtermapp.repository.UserRepository

class UserViewModelProviderFactory(
    val application: Application,
    val userRepository: UserRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(app = application, usersRepository = userRepository) as T
    }
}