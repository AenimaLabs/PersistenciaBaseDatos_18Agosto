package com.example.persistenciabasedatos_18agosto.model

import androidx.lifecycle.LiveData
import com.example.persistenciabasedatos_18agosto.database.TaskDAO

class TaskRepository (private val mTaskDAO: TaskDAO) {

    //1.Este value va a contener todos los task desde la base de datos
    val mAllTask: LiveData<List<Task>> = mTaskDAO.getAllTask()

    //2.esta función va a comunicarse con el DAO e insertar en la base de datos
    suspend fun insertTask(task: Task){
        mTaskDAO.insertTask(task)
    }


}