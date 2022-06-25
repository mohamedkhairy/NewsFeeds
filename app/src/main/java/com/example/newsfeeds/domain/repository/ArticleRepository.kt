package com.example.newsfeeds.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.newsfeeds.domain.core.Resource
import com.example.newsfeeds.domain.entity.ArticleDomainModel

interface ArticleRepository {


    suspend fun getHomeArticles(): Flow<Resource<MutableList<ArticleDomainModel>>>


}