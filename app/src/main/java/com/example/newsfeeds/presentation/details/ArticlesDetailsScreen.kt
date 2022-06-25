package com.example.newsfeeds.presentation.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsfeeds.presentation.component.ArticleImage
import com.example.newsfeeds.domain.entity.ArticleDomainModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ArticlesDetailsScreen(
    navigator: DestinationsNavigator,
    ArticleDetails: ArticleDomainModel
) {

    Column(
        modifier = Modifier
            .fillMaxSize()


    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentColor = Color.LightGray
        ) {

            Column() {


                ArticleImage(ArticleDetails.urlToImage)

                Text(

                    text = ArticleDetails.title,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(5.dp)
                )



                Text(
                    text = ArticleDetails.author ?: "--",
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(5.dp)

                )

                Text(
                    text = ArticleDetails.description,
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(5.dp)
                )

            }
        }

        Button(onClick = { }, modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            ,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
        ) {

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = "Open Website",
                color = Color.White,
                style = MaterialTheme.typography.h5,
                fontSize = 18.sp,
            )

        }

    }
}