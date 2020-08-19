package com.example.persistenciabasedatos_18agosto.presenter

import androidx.lifecycle.LiveData
import com.example.persistenciabasedatos_18agosto.model.Task

interface IView {

    fun showAllTask(list : LiveData<List<Task>>)
    fun showToastMEssage(message: String)

}