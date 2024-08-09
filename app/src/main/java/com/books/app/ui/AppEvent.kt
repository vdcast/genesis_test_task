package com.books.app.ui

sealed interface AppEvent {
    data class SelectBook(val bookId: Long): AppEvent
}