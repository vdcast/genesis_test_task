package com.books.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.data.toBook
import com.books.app.data.toTopBannerSlide
import com.books.app.domain.models.Book
import com.books.app.domain.remote.BooksDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val booksDataSource: BooksDataSource
): ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchBooks()
    }

    fun onEvent(event: AppEvent) {
        when (event) {
            is AppEvent.SelectBook -> {
                val selectedBook = findBookById(event.bookId)
                _uiState.update { it.copy(
                    selectedBook = selectedBook
                ) }
            }
        }
    }

    private fun fetchBooks() {
        viewModelScope.launch {
            val booksDto = booksDataSource.getBooks()
            val topBannerSlidesDto = booksDataSource.getTopBannerSlides()
            val youWillLikeSectionDto = booksDataSource.getYouWillLikeSection()

            val books = booksDto.map { it.toBook() }
            val topBannerSlides = topBannerSlidesDto.map { it.toTopBannerSlide() }
            val youWillLikeSection = books.filter { it.id in youWillLikeSectionDto }

            val booksByGenre = books.groupBy { it.genre }

            _uiState.update { it.copy(
                books = books,
                topBannerSlides = topBannerSlides,
                youWillLikeSection = youWillLikeSection,
                booksByGenre = booksByGenre
            ) }
        }
    }

    private fun findBookById(bookId: Long): Book? {
        return uiState.value.books.find { it.id == bookId }
    }
}