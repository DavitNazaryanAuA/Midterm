package com.aua.davitnazaryan.midtermapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aua.davitnazaryan.midtermapp.repository.UserRepository
import com.aua.davitnazaryan.midtermapp.viewModel.UserViewModelProviderFactory
import com.aua.davitnazaryan.midtermapp.viewModel.UsersViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRepository = UserRepository()
        val userViewModelProviderFactory = UserViewModelProviderFactory(application = application, userRepository = userRepository)
        viewModel = ViewModelProvider(this, userViewModelProviderFactory)[UsersViewModel::class.java]

    }
}