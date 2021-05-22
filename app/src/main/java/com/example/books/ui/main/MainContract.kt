package com.example.books.ui.main

import com.example.books.model.entities.Book

interface MainContract {
    interface View {

        fun showBooksFragment()

        fun showBookFragment(book: Book)

    }

    interface Presenter {

        fun onStart(view: View)

        fun onStop()

        fun openBooksFragment()

        fun openBookFragment(book: Book)

    }
}