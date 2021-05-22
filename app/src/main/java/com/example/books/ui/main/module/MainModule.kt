package com.example.books.ui.main.module

import com.example.books.model.ApiClient
import com.example.books.ui.book.BookFragment
import com.example.books.ui.book.module.BookModule
import com.example.books.ui.books.BooksFragment
import com.example.books.ui.books.module.BooksModule
import com.example.books.ui.main.MainContract
import com.example.books.ui.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    @Binds
    abstract fun presenter(presenter: MainPresenter): MainContract.Presenter

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun booksApiClient(factory: ApiClient.Factory) = factory.create()
    }

    @ContributesAndroidInjector(modules = [BooksModule::class])
    abstract fun booksFragment(): BooksFragment

    @ContributesAndroidInjector(modules = [BookModule::class])
    abstract fun bookFragment(): BookFragment

}