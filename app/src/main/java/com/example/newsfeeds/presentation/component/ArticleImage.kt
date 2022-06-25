package com.example.newsfeeds.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.newsfeeds.R


@Composable
fun ArticleImage(
    imageUrl: String,
){

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .error(R.drawable.placeholder)
            .data(imageUrl)
            .crossfade(true)
            .crossfade(200)
            .build()
)

    if (painter.state is AsyncImagePainter.State.Loading) {
        CircularProgressIndicator()
    }

    Image(
        painter = painter,
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(R.string.image_desc),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(150.dp)
    )

}