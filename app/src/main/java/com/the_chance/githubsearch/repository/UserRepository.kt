package com.the_chance.githubsearch.repository

import com.the_chance.githubsearch.model.UserSearchResponse

interface UserRepository {
    suspend fun searchUser(query: String): UserSearchResponse
    suspend fun getUserDetails(userName: String): UserSearchResponse

}