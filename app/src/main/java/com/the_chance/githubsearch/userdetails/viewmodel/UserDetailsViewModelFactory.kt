package com.the_chance.githubsearch.userdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.the_chance.githubsearch.repository.UserRepository

class UserDetailsViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(UserDetailsViewModel::class.java)){
            UserDetailsViewModel(repository) as T
        }else {
            throw IllegalArgumentException("UserDetailsViewModel Class Not Found")
        }
    }
}