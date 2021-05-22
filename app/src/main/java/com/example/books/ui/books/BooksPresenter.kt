package com.example.books.ui.books

import android.content.Context
import com.example.books.R
import com.example.books.model.repositories.BooksRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class BooksPresenter @Inject constructor(private val repo: BooksRepo) : BooksContract.Presenter {

    private var view: BooksContract.View? = null
    private var disposable: Disposable? = null
    private var context:Context?=null

    override fun onStart(view: BooksContract.View, context: Context?) {
        this.view = view
        this.context=context
        fetchBooks()
    }

    override fun onStop() {
        disposable?.dispose()
        this.view = null
    }

    fun fetchBooks() {
        disposable = repo.fetchBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val calendar:Calendar= Calendar.getInstance()
                val date: String = SimpleDateFormat("dd.MM.YYYY").format(calendar.time)
                val text=context?.getString(R.string.date,it.size,date)
                view?.showBooks(it,text) }, { view?.showError() })
    }

}