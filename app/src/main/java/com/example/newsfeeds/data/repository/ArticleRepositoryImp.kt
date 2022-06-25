package com.example.newsfeeds.data.repository

import com.example.newsfeeds.domain.core.Resource
import com.example.newsfeeds.data.source.mapper.ArticleToDomainMapper
import com.example.newsfeeds.data.source.remote.service.ArticleService
import com.example.newsfeeds.di.MyFirstArticles
import com.example.newsfeeds.di.MySecondArticles
import com.example.newsfeeds.domain.entity.ArticleDomainModel
import com.example.newsfeeds.domain.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class ArticleRepositoryImp @Inject constructor(
    @MyFirstArticles private val firstArticleService: ArticleService,
    @MySecondArticles private val secondArticleService: ArticleService,
    private val domainMapper: ArticleToDomainMapper) : ArticleRepository {

    override suspend fun getHomeArticles(): Flow<Resource<MutableList<ArticleDomainModel>>> =
        getFirstArticleService().zip(getSecondArticleService()) { r1, r2 ->
            try {
                val articlesList: MutableList<ArticleDomainModel> = mutableListOf()
                r1?.let { articlesList.addAll(it) }
                r2?.let { articlesList.addAll(it) }
                Resource.Success(articlesList)
            } catch (e: Exception) {
                Resource.Error(e.cause)
            }

        }.flowOn(Dispatchers.IO)


    private fun getFirstArticleService(): Flow<List<ArticleDomainModel>?> =
        flow {
            try {
                val result = firstArticleService.callNewsArticles()
                val mappedData = domainMapper.toDomainList(result.articles)
                emit(mappedData)

            } catch (e: Exception) {
                e.printStackTrace()
//                emit(e.cause)
            }
        }.flowOn(Dispatchers.IO)


    private fun getSecondArticleService(): Flow<List<ArticleDomainModel>?> =
        flow {
            try {
                val result2 = secondArticleService.callNewsArticles()
                val mappedData = domainMapper.toDomainList(result2.articles)
                emit(mappedData)

            } catch (e: Exception) {
                e.printStackTrace()
//                emit(e.cause)
            }
        }.flowOn(Dispatchers.IO)

}