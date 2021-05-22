package com.example.books.ui.books


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.books.databinding.BooksFragmentBinding
import com.example.books.model.entities.Book
import com.example.books.ui.books.adapters.BooksAdapter
import com.example.books.ui.main.MainContract
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BooksFragment : Fragment(), BooksContract.View {

    @Inject
    lateinit var mainPresenter: MainContract.Presenter

    private lateinit var binding: BooksFragmentBinding

    @Inject
    lateinit var presenter: BooksContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = BooksFragmentBinding.inflate(inflater).run {
        binding = this
        root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

    }


    override fun onStart() {
        super.onStart()
        presenter.onStart(this,context)

    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()

    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun showBooks(books: List<Book>,text:String?) {

        binding.run {
            recycleBooks.adapter = BooksAdapter(books,text, mainPresenter::openBookFragment)
        }
    }

}