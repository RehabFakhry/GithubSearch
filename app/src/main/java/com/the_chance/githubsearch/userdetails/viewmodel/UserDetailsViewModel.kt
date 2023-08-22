package com.the_chance.githubsearch.userdetails.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the_chance.githubsearch.model.UserSearchResponse
import com.the_chance.githubsearch.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailsViewModel(private val repository: UserRepository) : ViewModel() {

    private val _userDetailsResults = MutableLiveData<UserSearchResponse>()
    val userDetailsResults: LiveData<UserSearchResponse> = _userDetailsResults

    fun getUserDetailsUsers(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userDetailsResponse = repository.getUserDetails(userName)
                _userDetailsResults.value = userDetailsResponse

            } catch (message: Exception) {
                Log.e("tag", "cannot fetch data")
            }
        }
    }
}




//ViewModelProvider to create Object
// FactoryDesignPattern