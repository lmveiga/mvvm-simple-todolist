package com.gmail.lucasmveigabr.mvvmsimpletodolist.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.task.TaskFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    TaskFragment.newInstance()
                )
                .commitNow()
        }
    }

}
