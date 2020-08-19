package com.example.persistenciabasedatos_18agosto.presenter

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.persistenciabasedatos_18agosto.database.TaskDAO
import com.example.persistenciabasedatos_18agosto.database.TaskDataBase
import com.example.persistenciabasedatos_18agosto.model.Task
import com.example.persistenciabasedatos_18agosto.model.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TaskPresenter (application: Application, val iView: IView): IPresenter, CoroutineScope{

    private val mRepository: TaskRepository
    private val allLiveDAtaTask: LiveData<List<Task>>

    //Corrutina
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO


    init {
        val taskDAO = TaskDataBase.getDataBase(application).getTaskDAO()
        mRepository = TaskRepository(taskDAO)
        allLiveDAtaTask = mRepository.mAllTask
    }

    override fun inserTask(task: Task)  {
          //  mRepository.insertTask(task)
        inserTest(task)
            iView.showToastMEssage("Guardando")
        }

    fun inserTest(task: Task) = launch {
        mRepository.insertTask(task)

    }

    override fun getAllTask() {
       iView.showAllTask(allLiveDAtaTask)

    }



}