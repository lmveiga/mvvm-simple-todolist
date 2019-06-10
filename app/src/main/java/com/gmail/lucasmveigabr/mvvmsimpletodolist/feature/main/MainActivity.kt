package com.gmail.lucasmveigabr.mvvmsimpletodolist.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.feature.task.TaskFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    TaskFragment.newInstance()
                )
                .commitNow()
        }
    }

}
