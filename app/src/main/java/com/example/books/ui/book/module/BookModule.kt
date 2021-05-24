package com.example.books.ui.book.module

import com.example.books.ui.book.BookContract
import com.example.books.ui.book.BookPresenter
import dagger.Binds
import dagger.Module

@Module
interface BookModule {
    @Binds
    fun presenter(presenter: BookPresenter): BookContract.Presenter
}