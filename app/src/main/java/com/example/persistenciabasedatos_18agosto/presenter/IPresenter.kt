package com.example.persistenciabasedatos_18agosto.presenter

import com.example.persistenciabasedatos_18agosto.model.Task

interface IPresenter {

    fun inserTask(task: Task)
    fun getAllTask()
}