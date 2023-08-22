package com.the_chance.githubsearch.network

import com.the_chance.githubsearch.model.UserSearchResponse

object RetrofitClient :RemoteDataSource {
    override suspend fun searchUsers(query: String): UserSearchResponse {
        return RetrofitHelper.getInstance().create(GitHubApiService::class.java).searchUsers(query)
    }
}
