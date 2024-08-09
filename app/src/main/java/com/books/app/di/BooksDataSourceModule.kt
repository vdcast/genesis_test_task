package com.books.app.di

import com.books.app.data.remote.RemoteConfigBooksDataSource
import com.books.app.domain.remote.BooksDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BooksDataSourceModule {

    @Provides
    @Singleton
    fun provideBooksDataSource(): BooksDataSource {
        return RemoteConfigBooksDataSource()
    }
}