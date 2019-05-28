package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.main.MainViewModel

class TaskFragment : Fragment() {

    companion object {
        fun newInstance() = TaskFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.task_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
