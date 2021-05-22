package com.example.books.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.books.R
import com.example.books.model.entities.Book
import com.example.books.ui.book.BookFragment
import com.example.books.ui.books.BooksFragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    lateinit var actionTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionTitle = findViewById(R.id.actionTitle)
    }


    override fun onStart() {
        super.onStart()
        presenter.onStart(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun supportFragmentInjector() = injector

    override fun showBooksFragment() {
        actionTitle.setText(R.string.app_name)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.contentMain, BooksFragment())
            addToBackStack(null)
            commit()
        }
    }

    override fun showBookFragment(book: Book) {
        actionTitle.setText(book.title)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.contentMain, BookFragment.create(book))
            commit()
        }
    }

}
