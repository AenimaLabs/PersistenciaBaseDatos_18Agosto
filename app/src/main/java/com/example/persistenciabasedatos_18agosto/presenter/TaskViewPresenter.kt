package com.example.persistenciabasedatos_18agosto.presenter

import com.example.persistenciabasedatos_18agosto.model.Task

interface TaskViewPresenter {

    fun showAllTask(list : List<Task>)
}