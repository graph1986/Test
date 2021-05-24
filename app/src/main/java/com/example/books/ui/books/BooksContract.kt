package com.example.books.ui.books


import android.content.Context
import androidx.navigation.NavController
import com.example.books.model.entities.Book

interface BooksContract {

    interface View {

        fun showError()

        fun showBooks(books: List<Book>, footer: String)

    }

    interface Presenter {

        fun onStart(view: View)

        fun onBookClicked(navController: NavController, book: Book)

        fun onStop()

    }

}