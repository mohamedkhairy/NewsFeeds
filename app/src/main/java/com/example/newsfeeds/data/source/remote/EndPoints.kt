package com.example.newsfeeds.data.source.remote

object EndPoints {



    const val BASE_URL = "https://newsapi.org/v1"
    const val API_KEY = "533af958594143758318137469b41ba9"


    const val ARTICLE_URL_1 = "$BASE_URL/articles?source=the-next-web&apiKey=$API_KEY"
    const val ARTICLE_URL_2 = "$BASE_URL/articles?source=associated-press&apiKey=$API_KEY"


}