package com.example.newsfeeds.di

import com.example.newsfeeds.domain.repository.ArticleRepository
import com.example.newsfeeds.domain.useCases.ArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {



        @ViewModelScoped
        @Provides
        fun provideArticlesUseCase(articleRepository : ArticleRepository) : ArticlesUseCase {
            return ArticlesUseCase(articleRepository)
        }

}