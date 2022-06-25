package com.example.newsfeeds.data.source.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ArticlesResponse(
    @SerialName("articles")
    val articles: List<ArticleResponseItem>?,
    @SerialName("sortBy")
    val sortBy: String?,
    @SerialName("source")
    val source: String?,
    @SerialName("status")
    val status: String
)
@Serializable
data class ArticleResponseItem(
    @SerialName("author")
    val author: String?,
    @SerialName("description")
    val description: String,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String
)