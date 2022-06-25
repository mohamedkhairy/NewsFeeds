package com.example.newsfeeds.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsfeeds.presentation.component.ArticlesCardItem
import com.example.newsfeeds.presentation.destinations.ArticlesDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun ArticlesHomeScreen(
    navigator: DestinationsNavigator
) {
    val articlesViewModel: ArticlesViewModel = hiltViewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val articlesList = articlesViewModel.articlesList.value


        LazyColumn {
            itemsIndexed(items = articlesList) { index, item ->
                ArticlesCardItem(article = item){
                    navigator.navigate(
                        ArticlesDetailsScreenDestination(it)
                    )
                }
            }
        }
    }
}