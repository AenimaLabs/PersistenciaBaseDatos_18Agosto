package com.example.persistenciabasedatos_18agosto.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.persistenciabasedatos_18agosto.R
import com.example.persistenciabasedatos_18agosto.model.Task
import com.example.persistenciabasedatos_18agosto.presenter.IView
import com.example.persistenciabasedatos_18agosto.presenter.TaskPresenter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), IView {

    lateinit var presenter: TaskPresenter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        presenter = TaskPresenter(requireActivity().application, this)
        var task = Task(0, "Esto es una nota", "19/08/2020", "20/08/2020")

        presenter.inserTest(task)
        presenter.getAllTask()


        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun showAllTask(list: LiveData<List<Task>>) {
        list.observe(this, Observer {
            Log.e("TAG", it.toString())
        })
    }

    override fun showToastMEssage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}