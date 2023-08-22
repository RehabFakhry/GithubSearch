package com.the_chance.githubsearch.searchuser.view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.the_chance.githubsearch.R
import com.the_chance.githubsearch.ui.theme.imageNotFoundSize
import com.the_chance.githubsearch.ui.theme.space8
import com.the_chance.githubsearch.ui.theme.textSize16

@Composable
fun NoResultImage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.no_results_image),
                contentDescription = null,
                modifier = Modifier
                    .size(imageNotFoundSize)
                    .fillMaxWidth()
                    .padding(bottom = space8)
            )
            Text(
                text = stringResource(id = R.string.no_results_found),
                fontSize = textSize16)
        }
    }
}