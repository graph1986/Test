package com.example.books.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.books.databinding.BookFragmentBinding
import com.example.books.model.entities.Book
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BookFragment : Fragment(), BookContract.View {

    private lateinit var binding: BookFragmentBinding

    @Inject
    lateinit var presenter: BookContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = BookFragmentBinding.inflate(inflater).run {
        binding = this
        root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        presenter.book = arguments?.getSerializable(BOOK_KEY) as Book
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    companion object {
        const val BOOK_KEY = "book"

        fun create(book: Book): BookFragment = BookFragment().apply {
            arguments = Bundle().apply {
                putSerializable(BOOK_KEY, book)
            }
        }
    }

    override fun showBook(book: Book) {
        binding.run {
            Picasso.get().load(book.image)
                .fit()
                .centerCrop()
                .into(this.imgBook)
            txtAuthor.setText(book.author)
            txtDescription.setText(book.description)
        }
    }

}