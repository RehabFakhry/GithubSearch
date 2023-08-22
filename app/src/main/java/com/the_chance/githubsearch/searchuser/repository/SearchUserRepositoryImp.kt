package com.the_chance.githubsearch.searchuser.repository

import com.the_chance.githubsearch.model.UserSearchResponse
import com.the_chance.githubsearch.network.RemoteDataSource

class SearchUserRepositoryImp(private val remoteDataSource: RemoteDataSource)
    : SearchUserRepository {
    override suspend fun searchUser(query: String): UserSearchResponse {
        return remoteDataSource.searchUsers(query)
    }
}