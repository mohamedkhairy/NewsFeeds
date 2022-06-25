package com.example.newsfeeds.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsfeeds.domain.entity.ArticleDomainModel

@Composable
fun ArticlesCardItem(
    article: ArticleDomainModel,
    goToDetails: (ArticleDomainModel) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(260.dp)
            .padding(8.dp)
            .clickable { goToDetails(article) }
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
        ) {
            ArticleImage(article.urlToImage)

            Text(

                text = article.title,
                color = MaterialTheme.colors.onBackground,
                fontSize = 18.sp,
                modifier = Modifier.padding(5.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Text(
                    text = article.author ?: "--",
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 14.sp

                )

                Text(
                    text = article.publishedAt,
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 14.sp
                )

            }

        }
    }
}
