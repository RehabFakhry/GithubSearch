package com.the_chance.githubsearch.model

import com.google.gson.annotations.SerializedName

data class UserSearchResponse(
    val items: List<UserItem>,
    val userDetails: UserDetails
)

data class UserItem(
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)

data class UserDetails(
    val name: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String? = "" ,
    val following: Int,
    val followers: Int,
    @SerializedName("public_repos")
    val publicRepos: Int,
    val company: String? = "",
    val bio: String? = "",
)