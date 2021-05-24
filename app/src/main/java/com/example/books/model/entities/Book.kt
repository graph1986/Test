package com.example.books.model.entities

import java.io.Serializable

data class Book(
    val textId: String,
    val title: String,
    val image: String,
    val rating: Float,
    val description: String,
    val author: String
) : Serializable