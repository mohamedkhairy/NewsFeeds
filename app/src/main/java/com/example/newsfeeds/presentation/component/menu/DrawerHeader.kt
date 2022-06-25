package com.example.newsfeeds.presentation.component.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsfeeds.R


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "user image",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.h6,
                )

                Text(
                    text = "Tony Roshdy",
                    style = MaterialTheme.typography.h5,
                )
            }

            Icon(
                painter = painterResource(R.drawable.arrow),
                contentDescription = "arrow",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}