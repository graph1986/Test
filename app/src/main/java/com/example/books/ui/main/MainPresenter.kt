package com.example.books.ui.main

import com.example.books.model.entities.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor() : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart(view: MainContract.View) {
        this.view=view
        view.showBooksFragment()
    }

    override fun onStop() {
        this.view = null
    }

    override fun openBooksFragment() {
        view?.showBooksFragment()
    }

    override fun openBookFragment(book: Book) {
        view?.showBookFragment(book)
    }

}