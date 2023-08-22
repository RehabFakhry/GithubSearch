package com.the_chance.githubsearch.network

import com.the_chance.githubsearch.model.UserSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") query: String): UserSearchResponse
}