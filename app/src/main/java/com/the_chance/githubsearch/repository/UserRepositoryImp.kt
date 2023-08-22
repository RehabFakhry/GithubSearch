package com.the_chance.githubsearch.repository

import com.the_chance.githubsearch.model.UserSearchResponse
import com.the_chance.githubsearch.network.RemoteDataSource

class UserRepositoryImp(private val remoteDataSource: RemoteDataSource)
    : UserRepository {
    override suspend fun searchUser(query: String): UserSearchResponse {
        return remoteDataSource.searchUsers(query)
    }

    override suspend fun getUserDetails(userName: String): UserSearchResponse {
        return remoteDataSource.getUserDetails(userName)
    }
}