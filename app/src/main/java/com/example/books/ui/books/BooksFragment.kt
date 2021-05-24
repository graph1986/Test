package com.example.books.ui.books

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.books.R
import com.example.books.databinding.BooksFragmentBinding
import com.example.books.model.entities.Book
import com.example.books.ui.books.adapters.BooksAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class BooksFragment : Fragment(), BooksContract.View {

    @Inject
    lateinit var presenter: BooksContract.Presenter

    private lateinit var binding: BooksFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = BooksFragmentBinding.inflate(inflater).run {
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dividerItemDecoration = DividerItemDecoration(requireContext(), RecyclerView.VERTICAL)
        binding.recycleBooks.addItemDecoration(dividerItemDecoration)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart(this)

    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()

    }

    override fun showError() {
        Toast.makeText(requireContext(), R.string.connection_error, Toast.LENGTH_SHORT).show()
    }

    override fun showBooks(books: List<Book>, footer: String) {
        binding.run {
            recycleBooks.adapter =
                BooksAdapter(books, footer) { presenter.onBookClicked(findNavController(), it) }
        }
    }

}