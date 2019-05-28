package com.gmail.lucasmveigabr.mvvmsimpletodolist.di

import com.gmail.lucasmveigabr.mvvmsimpletodolist.app.App
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent {
    fun inject(app: App)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent

    }
}