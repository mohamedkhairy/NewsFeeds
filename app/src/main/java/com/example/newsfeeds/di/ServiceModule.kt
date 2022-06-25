package com.example.newsfeeds.di

import com.example.newsfeeds.data.source.remote.service.ArticleService
import com.example.newsfeeds.data.source.remote.service.FirstArticleServiceImpl
import com.example.newsfeeds.data.source.remote.service.SecondArticleServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier


@Module
@InstallIn(ViewModelComponent::class)
interface  ServiceModule {

    @Binds
    @MyFirstArticles
    fun provideFirstArticleService(firstArticles: FirstArticleServiceImpl): ArticleService

    @Binds
    @MySecondArticles
    fun provideSecondArticleService(secondArticles: SecondArticleServiceImpl): ArticleService

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MyFirstArticles

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MySecondArticles

