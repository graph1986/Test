package com.example.books.di


import com.example.books.ui.main.MainActivity
import com.example.books.ui.main.module.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Module(includes = [AndroidSupportInjectionModule::class])
abstract class AppModule() {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}