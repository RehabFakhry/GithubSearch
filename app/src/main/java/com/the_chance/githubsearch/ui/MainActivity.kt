package com.the_chance.githubsearch.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.the_chance.githubsearch.ui.navigation.Screens
import com.the_chance.githubsearch.network.RetrofitClient
import com.the_chance.githubsearch.repository.UserRepositoryImp
import com.the_chance.githubsearch.searchuser.view.SearchScreen
import com.the_chance.githubsearch.searchuser.viewmodel.SearchViewModel
import com.the_chance.githubsearch.searchuser.viewmodel.SearchViewModelFactory
import com.the_chance.githubsearch.userdetails.view.UserDetailsScreen
import com.the_chance.githubsearch.userdetails.viewmodel.UserDetailsViewModel
import com.the_chance.githubsearch.userdetails.viewmodel.UserDetailsViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var userDetailsViewModel: UserDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val searchViewModelFactory = SearchViewModelFactory(UserRepositoryImp(RetrofitClient))
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory)[SearchViewModel::class.java]


        val userDetailsViewModelFactory =
            UserDetailsViewModelFactory(UserRepositoryImp(RetrofitClient), )
        userDetailsViewModel =
            ViewModelProvider(this, userDetailsViewModelFactory)[UserDetailsViewModel::class.java]

        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screens.SearchUser.route
                ) {
                    composable(Screens.SearchUser.route) {
                        SearchScreen(viewModel = searchViewModel, navController)
                    }

                    composable(
                        "${Screens.UserDetails.route}/{login}",
                        arguments = listOf(
                            navArgument("login") { NavType.StringType },)
                    ) { backStackEntry ->
                        val login = backStackEntry.arguments?.getString("login")
//                        val userImage = backStackEntry.arguments?.getString("avatar_url")


                        Log.d("MainActivity", "Received login argument: $login")
                        if (login != null ) {
                            UserDetailsScreen(
                                userDetailsViewModel,
                                userName = login,
//                                userImage = userImage
                            )
                            Log.d(
                                "MainActivity",
                                "Saved login argument to SavedStateHandle: $login"
                            )

                        } else {
                            Log.e("MainActivity", "Login argument is null")
                        }
                    }
                }
            }
        }
    }
}