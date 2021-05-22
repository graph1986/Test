package com.example.books.ui.book.module

import com.example.books.ui.book.BookContract
import com.example.books.ui.book.BookPresenter
import dagger.Binds
import dagger.Module

@Module
interface BookModule {
    @Binds
    abstract fun presenter(prenter: BookPresenter): BookContract.Presenter
}