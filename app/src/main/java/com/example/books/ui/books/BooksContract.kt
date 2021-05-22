package com.example.books.ui.books


import android.content.Context
import com.example.books.model.entities.Book

interface BooksContract {

    interface View {

        fun showError()

        fun showBooks(books: List<Book>,text:String?)

    }

    interface Presenter {

        fun onStart(view: View, context: Context?)

        fun onStop()

    }

}