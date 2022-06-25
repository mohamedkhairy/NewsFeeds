package com.example.newsfeeds.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsfeeds.domain.core.Resource
import com.example.newsfeeds.domain.entity.ArticleDomainModel
import com.example.newsfeeds.domain.useCases.ArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val articlesUseCase: ArticlesUseCase) :
    ViewModel() {

    val articlesList: MutableState<List<ArticleDomainModel>> = mutableStateOf(ArrayList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val isError: MutableState<Boolean> = mutableStateOf(false)

    init {
        getNewsArticlesList()
    }

/**
 * this method can emit 3 state to UI
 * Loading -> when the app trying to get data
 * Success -> when data return successfully
 * Error -> will return old data if it's available or Error if not
 * */
    fun getNewsArticlesList() {
        viewModelScope.launch(Dispatchers.Main) {
            articlesUseCase.invoke().collect {
                when (it) {
                    is Resource.Loading -> {
                        loading.value = true
                        isError.value = false
                    }
                    is Resource.Success -> {
                        loading.value = false
                        isError.value = false
                        it.data?.let { list -> articlesList.value = list }
                    }
                    is Resource.Error -> {
                        loading.value = false
                            isError.value = true


                    }
                }
            }
        }
    }





}