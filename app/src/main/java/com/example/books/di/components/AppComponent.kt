package com.example.books.di.components


import android.content.Context
import com.example.books.core.BooksApplication
import com.example.books.di.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(app: BooksApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun getContext(context: Context): Builder

        fun build(): AppComponent
    }
}