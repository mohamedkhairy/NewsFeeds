package com.example.newsfeeds.data.source.remote.service

import com.example.newsfeeds.data.source.remote.ArticlesResponse

interface ArticleService {

    suspend fun callNewsArticles(): ArticlesResponse


}
