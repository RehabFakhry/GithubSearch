package com.the_chance.githubsearch.userdetails.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the_chance.githubsearch.model.UserDetails
import com.the_chance.githubsearch.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val repository: UserRepository,
) : ViewModel() {

    private val _userDetailsResults = MutableLiveData<UserDetails>()
    val userDetailsResults: LiveData<UserDetails> = _userDetailsResults

    fun getUserDetails(userName: String, ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userDetailsResponse = repository.getUserDetails(userName,)
                _userDetailsResults.postValue(userDetailsResponse)

            } catch (e: Exception) {
                Log.e("tag", "Error fetching data: ${e.message}", e)
            }
        }
    }
}