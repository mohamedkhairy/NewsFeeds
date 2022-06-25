package com.example.newsfeeds.domain.useCases


import kotlinx.coroutines.flow.Flow
import com.example.newsfeeds.domain.core.Resource
import com.example.newsfeeds.domain.entity.ArticleDomainModel
import com.example.newsfeeds.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticlesUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    suspend fun invoke(): Flow<Resource<MutableList<ArticleDomainModel>>> =
        articleRepository.getHomeArticles()


}
