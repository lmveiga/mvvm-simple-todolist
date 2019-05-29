package com.gmail.lucasmveigabr.mvvmsimpletodolist.app

import android.app.Application
import com.gmail.lucasmveigabr.mvvmsimpletodolist.di.AppComponent
import com.gmail.lucasmveigabr.mvvmsimpletodolist.di.ContextModule
import com.gmail.lucasmveigabr.mvvmsimpletodolist.di.DaggerAppComponent
import com.gmail.lucasmveigabr.mvvmsimpletodolist.di.RoomModule

class App: Application() {

    companion object{
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().contextModule(ContextModule(this))
            .roomModule(RoomModule()).build()
    }

}