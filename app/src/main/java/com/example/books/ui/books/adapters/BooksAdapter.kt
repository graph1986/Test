package com.example.books.ui.books.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.books.databinding.BookItemBinding
import com.example.books.databinding.FooterItemBinding
import com.example.books.model.entities.Book
import com.squareup.picasso.Picasso

class BooksAdapter(val books: List<Book>,val text:String?, private val onClick: (Book) -> Unit) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    private val bookWrappers = mutableListOf<BookWrapper>()

    init {
        books.forEach {
            bookWrappers.add(BookWrapper(it, Type.Book))
        }
        bookWrappers.add(BookWrapper(null, Type.Footer))
    }

    override fun getItemViewType(position: Int) = bookWrappers[position].type.type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        Type.Book.type -> ViewHolder.BookViewHolder(
            BookItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
        else -> {
            ViewHolder.FooterViewHolder(
                FooterItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun getItemCount() = bookWrappers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            Type.Book.type -> (holder as ViewHolder.BookViewHolder).run {
                binding.run {
                    Picasso.get().load(books.get(position).image)
                        .fit()
                        .centerCrop()
                        .into(this.imgBooks)
                    txtTitle.setText(books.get(position).title)
                    root.setOnClickListener {
                        onClick(books.get(position))
                    }
                }
            }
            else -> (holder as ViewHolder.FooterViewHolder).run {
                binding.run {
                    txtItem.setText(text)
                }
            }
        }
    }

    sealed class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        class BookViewHolder(val binding: BookItemBinding) : ViewHolder(binding.root)

        class FooterViewHolder(val binding: FooterItemBinding) : ViewHolder(binding.root)
    }

    data class BookWrapper(val book: Book?, val type: Type)

    enum class Type(val type: Int) {
        Book(0), Footer(1)
    }
}