package com.example.books.ui.books

import android.content.Context
import androidx.navigation.NavController
import com.example.books.R
import com.example.books.core.Navigator
import com.example.books.model.entities.Book
import com.example.books.model.repositories.BooksRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class BooksPresenter @Inject constructor(
    private val repo: BooksRepo,
    private val context: Context,
    private val navigator: Navigator
) : BooksContract.Presenter {

    private var view: BooksContract.View? = null
    private var disposable: Disposable? = null

    override fun onStart(view: BooksContract.View) {
        this.view = view
        fetchBooks()
    }

    override fun onBookClicked(navController: NavController, book: Book) =
        navigator.openBookScreen(navController, book)

    override fun onStop() {
        disposable?.dispose()
        this.view = null
    }

    fun fetchBooks() {
        disposable = repo.fetchBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val date = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
                val footer = context.getString(R.string.footer, it.size, date)
                view?.showBooks(it, footer)
            }, { view?.showError() })
    }

}