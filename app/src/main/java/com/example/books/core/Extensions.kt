package com.example.books.core

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.setTitle(title: String) {
    val activity = this.requireActivity() as AppCompatActivity
    activity.supportActionBar?.title = title
}