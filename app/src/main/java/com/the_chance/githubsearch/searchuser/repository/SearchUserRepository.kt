package com.the_chance.githubsearch.searchuser.repository

import com.the_chance.githubsearch.model.UserSearchResponse

interface SearchUserRepository {
    suspend fun searchUser(query: String): UserSearchResponse
}