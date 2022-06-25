package com.example.newsfeeds.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsfeeds.R

@Composable
fun MainAppBar(
    onNavigationIconClick: () -> Unit,
    isExpandedScreen: Boolean = false,

) {

    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.link_dev),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        },
        navigationIcon = if (!isExpandedScreen) {
            {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = stringResource(R.string.menu_desc),
                        tint = Color.White

                    )
                }
            }
        } else {
            null
        }
        ,
        actions = {
            IconButton(
                onClick = { /* TODO: Open search */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(R.string.search_desc),
                    tint = Color.White

                )
            }
        },
        backgroundColor = Color.Black,
        elevation = 0.dp
    )
//    TopAppBar(
//        title = {
//            Text(text = stringResource(id = R.string.app_name))
//        },
//        backgroundColor = MaterialTheme.colors.primary,
//        contentColor = MaterialTheme.colors.onPrimary,
//        navigationIcon = {
//            IconButton(onClick = onNavigationIconClick) {
//                Icon(
//                    imageVector = Icons.Default.Menu,
//                    contentDescription = "Toggle drawer"
//                )
//            }
//
//            IconButton(onClick = onSearchIconClick) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search"
//                )
//            }
//        }
//    )
}