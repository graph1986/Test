package com.example.books.model

import com.example.books.model.entities.Book
import com.example.books.model.repositories.BooksRepo
import io.reactivex.Single
import javax.inject.Inject

class HttpBooksRepo @Inject constructor(private val apiClient: ApiClient) : BooksRepo {
    override fun fetchBooks(): Single<List<Book>> = apiClient.fetchBooks()
}