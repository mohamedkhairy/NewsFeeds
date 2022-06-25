package com.example.newsfeeds.data.utils

interface ModelMapper <T, DomainModel>{

    fun mapToRestaurantModel(model: T): DomainModel

}