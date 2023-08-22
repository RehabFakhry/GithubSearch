package com.the_chance.githubsearch.searchuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the_chance.githubsearch.model.UserItem
import com.the_chance.githubsearch.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val repository: UserRepository) : ViewModel() {

    private val _searchResults = MutableLiveData<List<UserItem>>()
    val searchResults: LiveData<List<UserItem>> = _searchResults

    fun searchUsers(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.searchUser(query)
                if (response.items.isNotEmpty()) {
                    val userSearchResponse = response.items
                    _searchResults.postValue(userSearchResponse)
                } else {
                    _searchResults.postValue(emptyList())
                }
            } catch (e: Exception) {
                _searchResults.postValue(emptyList())
            }
        }
    }
}







//ViewModelProvider to create Object
// FactoryDesignPattern