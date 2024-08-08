package com.books.app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.domain.BooksDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val booksDataSource: BooksDataSource
): ViewModel() {

    init {
        getBooksTest()
    }

    private fun getBooksTest() {
        viewModelScope.launch {
            val books = booksDataSource.getBooks()
            books.forEach {
                Log.d("MYLOG", it.toString())
            }
            val topBannerSlides = booksDataSource.getTopBannerSlides()
            topBannerSlides.forEach {
                Log.d("MYLOG", it.toString())
            }
            val youWillLikeSection = booksDataSource.getYouWillLikeSection()
            youWillLikeSection.forEach {
                Log.d("MYLOG", it.toString())
            }
        }
    }
}