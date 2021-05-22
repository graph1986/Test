package com.example.books.ui.book

import com.example.books.model.entities.Book
import javax.inject.Inject

class BookPresenter @Inject constructor() : BookContract.Presenter {

    private var view: BookContract.View? = null
    override var book: Book? = null

    override fun onStart(view: BookContract.View) {
        this.view = view
        book?.let(view::showBook)
    }

    override fun onStop() {
        this.view = null
    }

}