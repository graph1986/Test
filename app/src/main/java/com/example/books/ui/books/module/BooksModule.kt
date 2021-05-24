package com.example.books.ui.books.module

import com.example.books.model.ApiClient
import com.example.books.model.HttpBooksRepo
import com.example.books.model.repositories.BooksRepo
import com.example.books.ui.books.BooksContract
import com.example.books.ui.books.BooksPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BooksModule {

    @Binds
    abstract fun repo(repo: HttpBooksRepo): BooksRepo

    @Binds
    abstract fun presenter(presenter: BooksPresenter): BooksContract.Presenter

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun booksApiClient(factory: ApiClient.Factory) = factory.create()
    }

}