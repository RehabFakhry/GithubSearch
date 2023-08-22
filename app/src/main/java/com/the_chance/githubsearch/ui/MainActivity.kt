package com.the_chance.githubsearch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.ViewModelProvider
import com.the_chance.githubsearch.network.RetrofitClient
import com.the_chance.githubsearch.searchuser.repository.SearchUserRepositoryImp
import com.the_chance.githubsearch.searchuser.view.SearchScreen
import com.the_chance.githubsearch.searchuser.viewmodel.SearchViewModel
import com.the_chance.githubsearch.searchuser.viewmodel.SearchViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: SearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchViewModelFactory = SearchViewModelFactory(SearchUserRepositoryImp(RetrofitClient))
        viewModel = ViewModelProvider(this, searchViewModelFactory)[SearchViewModel::class.java]
        setContent {
            MaterialTheme {
                SearchScreen(viewModel = viewModel)
            }
        }
    }
}