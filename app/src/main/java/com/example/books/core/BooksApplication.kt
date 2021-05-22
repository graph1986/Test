package com.example.books.core

import android.app.Activity
import android.app.Application
import com.example.books.di.components.AppComponent
import com.example.books.di.components.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BooksApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .getContext(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun activityInjector() = injector

}