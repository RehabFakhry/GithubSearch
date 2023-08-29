package com.the_chance.githubsearch.network

import com.the_chance.githubsearch.model.UserDetails
import com.the_chance.githubsearch.model.UserSearchResponse

object RetrofitClient :RemoteDataSource {
    override suspend fun searchUsers(query: String): UserSearchResponse {
        return RetrofitHelper.getInstance().create(GitHubApiService::class.java).searchUsers(query)
    }

    override suspend fun getUserDetails(
        userName: String,
//        userImage: String
    ): UserDetails {
        return RetrofitHelper.getInstance().create(GitHubApiService::class.java)
            .getUserDetails(userName, )
    }
}