package com.example.books.ui.book

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.books.core.setTitle
import com.example.books.databinding.BookFragmentBinding
import com.example.books.model.entities.Book
import com.squareup.picasso.Picasso
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class BookFragment : Fragment(), BookContract.View {

    @Inject
    lateinit var presenter: BookContract.Presenter

    private lateinit var binding: BookFragmentBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.book?.title?.let(::setTitle)//{setTitle(it)}
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
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

    companion object {
        const val BOOK_KEY = "book"
    }

}