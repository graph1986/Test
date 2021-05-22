package com.example.books.ui.book

import com.example.books.model.entities.Book

interface BookContract {

    interface View {

        fun showBook(book: Book)

    }

    interface Presenter {

        var book: Book?

        fun onStart(view: View)

        fun onStop()

    }

}