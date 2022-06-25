package com.example.newsfeeds.domain.entity


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleDomainModel(
    val author: String? ,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
): Parcelable
