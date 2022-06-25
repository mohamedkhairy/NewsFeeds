package com.example.newsfeeds.di

import com.example.newsfeeds.data.source.mapper.ArticleToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideDomainMapper (): ArticleToDomainMapper {
        return ArticleToDomainMapper()
    }
}