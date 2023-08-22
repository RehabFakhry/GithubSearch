package com.the_chance.githubsearch.network

import com.the_chance.githubsearch.model.UserSearchResponse

interface RemoteDataSource {
    suspend fun searchUsers(query: String): UserSearchResponse
    suspend fun getUserDetails(userId: Long): UserSearchResponse
}