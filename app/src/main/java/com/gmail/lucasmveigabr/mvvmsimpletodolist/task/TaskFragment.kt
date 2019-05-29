package com.gmail.lucasmveigabr.mvvmsimpletodolist.task

import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail.lucasmveigabr.mvvmsimpletodolist.R
import com.gmail.lucasmveigabr.mvvmsimpletodolist.app.App
import com.gmail.lucasmveigabr.mvvmsimpletodolist.main.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.task_fragment.*


class TaskFragment : Fragment() {

    private val taskAdapter = TaskAdapter(App.appComponent.appContext()) {
        taskViewModel.recyclerItemClick(it)
    }

    companion object {
        fun newInstance() = TaskFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.task_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel::class.java)
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        taskViewModel.getTasks().observe(viewLifecycleOwner, Observer { tasks ->
            taskAdapter.setTasks(tasks)
        })
        taskViewModel.getDialogEvent().observe(viewLifecycleOwner, Observer {
            showAddDialog()
        })
        taskViewModel.getDeletedEvent().observe(viewLifecycleOwner, Observer {
            showDeletedSnackbar(it)
        })
        task_recycler_view.layoutManager = LinearLayoutManager(requireActivity())
        task_recycler_view.adapter = taskAdapter
        val touchHelper = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                taskViewModel.recyclerItemSwipe(taskAdapter.getTask(viewHolder.adapterPosition))
            }
        }
        ItemTouchHelper(touchHelper).attachToRecyclerView(task_recycler_view)
        fab.setOnClickListener {
            taskViewModel.addButtonClick()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.task_fragment_menu, menu)
        val searchItem = menu.findItem(R.id.action_search).actionView as SearchView?
        searchItem?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                taskViewModel.searchChange(p0 ?: "")
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                taskViewModel.searchChange(p0 ?: "")
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun showDeletedSnackbar(task: Task){
        view?.let {
            Snackbar.make(it, R.string.task_deleted, Snackbar.LENGTH_LONG)
                .setAction(R.string.undo){
                    taskViewModel.undoSnackbarClick(task)
                }.show()
        }
    }

    private fun showAddDialog() {
        activity?.let { context ->
            val editText = EditText(context)
            AlertDialog.Builder(context)
                .setView(editText)
                .setTitle(R.string.add_task)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    taskViewModel.addDialog(editText.text.toString())
                }
                .setNeutralButton(android.R.string.cancel, null)
                .create().show()
        }
    }

}
