package com.the_chance.githubsearch.searchuser.view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.the_chance.githubsearch.model.UserItem
import com.the_chance.githubsearch.ui.theme.imageSize
import com.the_chance.githubsearch.ui.theme.space16
import com.the_chance.githubsearch.ui.theme.space8
import com.the_chance.githubsearch.ui.theme.textSize20

@Composable
fun UserItemCard(user: UserItem, onClick:(String) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick(user.login) }
            .fillMaxWidth()
            .padding(space8),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(space16),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space8)
        ) {
            Image(
                painter = rememberAsyncImagePainter(user.avatarUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(imageSize)
            )
            Text(text = user.login,
                fontSize = textSize20,
                fontWeight = FontWeight.Medium)
        }
    }
}