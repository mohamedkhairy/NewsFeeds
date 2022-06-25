package com.example.newsfeeds.data.source.mapper

import com.example.newsfeeds.data.utils.ModelMapper
import com.example.newsfeeds.data.source.remote.ArticleResponseItem
import com.example.newsfeeds.domain.entity.ArticleDomainModel


class ArticleToDomainMapper : ModelMapper<ArticleResponseItem, ArticleDomainModel> {

    override fun mapToRestaurantModel(model: ArticleResponseItem): ArticleDomainModel {
        return ArticleDomainModel(
            model.author,
            model.description,
            model.publishedAt,
            model.title,
            model.url,
            model.urlToImage
        )

    }


    fun toDomainList(initial: List<ArticleResponseItem>?): List<ArticleDomainModel>? {
        return initial?.map { mapToRestaurantModel(it) }
    }


}