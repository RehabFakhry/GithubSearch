package com.the_chance.githubsearch.userdetails.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.the_chance.githubsearch.ui.theme.imageSize
import com.the_chance.githubsearch.ui.theme.space16
import com.the_chance.githubsearch.ui.theme.space4
import com.the_chance.githubsearch.ui.theme.space8
import com.the_chance.githubsearch.ui.theme.textSize24
import com.the_chance.githubsearch.userdetails.viewmodel.UserDetailsViewModel

@Composable
fun UserDetailsScreen(userDetailsViewModel: UserDetailsViewModel){
    val userDetails = userDetailsViewModel.userDetailsResults.observeAsState()

    userDetails.value?.let { userDetailsData ->
        LaunchedEffect(Unit) {
            userDetailsViewModel.getUserDetailsUsers(userDetailsData.userDetails.name!!)
        }
        Column(
            modifier = Modifier
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = userDetailsData.userDetails.avatarUrl),
                contentDescription = "User Image",
                modifier = Modifier
                    .size(imageSize)
                    .padding(bottom = space16)
            )
            Text(
                text = userDetailsData.userDetails.name ?: "No Name",
                fontSize = textSize24, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = space16))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(space16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space8)) {

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(space16),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Following")
                    Text(text = "${userDetailsData.userDetails.following}")
                }

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(space16),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Followers")
                    Text(text = "${userDetailsData.userDetails.followers}")
                }

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(space16),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Public Repositories")
                    Text(text = "${userDetailsData.userDetails.publicRepos}")
                }
            }
        }
    }
}