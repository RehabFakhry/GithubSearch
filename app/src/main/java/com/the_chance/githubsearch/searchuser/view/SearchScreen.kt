package com.the_chance.githubsearch.searchuser.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.githubsearch.R
import com.the_chance.githubsearch.searchuser.view.composable.NoResultImage
import com.the_chance.githubsearch.searchuser.view.composable.UserItemCard
import com.the_chance.githubsearch.searchuser.viewmodel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(viewModel: SearchViewModel) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    val searchResults by viewModel.searchResults.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.searchUsers(searchText.text)
            },
            placeholder = {
                Text(
                    text = stringResource(R.string.search_github_users),
                    fontSize = 12.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
        )

        if (searchResults.isNotEmpty()) {
            LazyColumn {
                items(searchResults) { resultItem ->
                    UserItemCard(user = resultItem)
                }
            }
        } else {
            NoResultImage()
        }
    }
}