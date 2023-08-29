package com.the_chance.githubsearch.userdetails.view

import android.util.Log
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.the_chance.githubsearch.R
import com.the_chance.githubsearch.ui.theme.space16
import com.the_chance.githubsearch.ui.theme.space4
import com.the_chance.githubsearch.ui.theme.space8
import com.the_chance.githubsearch.ui.theme.textSize16
import com.the_chance.githubsearch.ui.theme.textSize20
import com.the_chance.githubsearch.ui.theme.textSize24
import com.the_chance.githubsearch.userdetails.viewmodel.UserDetailsViewModel

@Composable
fun UserDetailsScreen(
    userDetailsViewModel: UserDetailsViewModel,
    userName: String,
){

    userDetailsViewModel.getUserDetails(userName, )

    Log.d("tag", "data fetched successfully")

    val userDetails = userDetailsViewModel.userDetailsResults.observeAsState()

    userDetails.value?.let { userDetailsData ->
        Column(
            modifier = Modifier.padding(space16)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = userDetailsData.avatarUrl),
                contentDescription = "User Image",
                modifier = Modifier
                    .size(320.dp)
                    .padding(bottom = space16)
            )

            Text(
                text = userDetailsData.name ?: "No UserName",
                fontSize = textSize24, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = space16),
            )

            Text(
                text = userDetailsData.bio ?: "no bio" ,
                fontSize = textSize20, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = space16),
            )

            Text(
                text = userDetailsData.company ?: "no Company" ,
                fontSize = textSize16, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = space16),
            )

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(space16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space8)) {

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(space8),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(R.string.following))
                    Text(text = "${userDetailsData.following}")
                }

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = space16, vertical = space8),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(R.string.followers))
                    Text(text = "${userDetailsData.followers}")
                }

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(space8),
                    verticalArrangement = Arrangement.spacedBy(space4),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = stringResource(R.string.public_repositories))
                    Text(text = "${userDetailsData.publicRepos}")
                }
            }
        }
    }
}