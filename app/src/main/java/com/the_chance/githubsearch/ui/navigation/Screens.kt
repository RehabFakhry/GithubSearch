package com.the_chance.githubsearch.ui.navigation

sealed class Screens(
    val route: String
){
    object SearchUser: Screens("searchScreen")
    object UserDetails: Screens("userDetails")
}