package com.example.books.core

import android.os.Bundle
import androidx.navigation.NavController
import com.example.books.R
import com.example.books.model.entities.Book
import com.example.books.ui.book.BookFragment
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openBookScreen(navController: NavController, book: Book) {
        navController.navigate(R.id.action_booksFragment_to_bookFragment, Bundle().apply {
            putSerializable(BookFragment.BOOK_KEY, book)
        })
    }

}