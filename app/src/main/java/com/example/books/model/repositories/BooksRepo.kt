package com.example.books.model.repositories

import com.example.books.model.entities.Book
import io.reactivex.Single

interface BooksRepo {

    fun fetchBooks(): Single<List<Book>>

}