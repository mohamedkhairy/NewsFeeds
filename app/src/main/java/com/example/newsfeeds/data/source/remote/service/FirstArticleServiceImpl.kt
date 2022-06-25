package com.example.newsfeeds.data.source.remote.service


import com.example.newsfeeds.data.source.remote.ArticlesResponse
import com.example.newsfeeds.data.source.remote.EndPoints
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class FirstArticleServiceImpl @Inject constructor(val httpClient: HttpClient):
    ArticleService {


    override suspend fun callNewsArticles(): ArticlesResponse {
        return httpClient.get<ArticlesResponse> {
            url(EndPoints.ARTICLE_URL_1)
        }
    }


}