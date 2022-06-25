package com.example.newsfeeds.di


import com.example.newsfeeds.data.repository.ArticleRepositoryImp
import com.example.newsfeeds.data.source.mapper.ArticleToDomainMapper
import com.example.newsfeeds.data.source.remote.service.ArticleService
import com.example.newsfeeds.di.MyFirstArticles
import com.example.newsfeeds.di.MySecondArticles
import com.example.newsfeeds.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object ArticleModule {

    @ViewModelScoped
    @Provides
    fun provideTrendingRepository(@MyFirstArticles firstArticleService: ArticleService,
                                  @MySecondArticles secondArticleService: ArticleService,
                                  domainMapper: ArticleToDomainMapper) : ArticleRepository {
        return ArticleRepositoryImp(firstArticleService, secondArticleService, domainMapper)
    }



}