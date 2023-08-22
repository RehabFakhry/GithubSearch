package com.the_chance.githubsearch.searchuser.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.the_chance.githubsearch.searchuser.repository.SearchUserRepository

class SearchViewModelFactory(private val repository: SearchUserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(SearchViewModel::class.java)){
            SearchViewModel(repository) as T
        }else {
            throw IllegalArgumentException("SearchViewModel Class Not Found")
        }
    }
}