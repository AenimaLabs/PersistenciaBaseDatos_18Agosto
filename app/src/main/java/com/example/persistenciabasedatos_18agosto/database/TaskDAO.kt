package com.example.persistenciabasedatos_18agosto.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.persistenciabasedatos_18agosto.model.Task

@Dao
interface TaskDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Insert
    fun insertMultipleTask (list: List<Task>)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteOneTask (task: Task)

    @Query ("Select * FROM task_table ORDER BY idTask ASC")
    fun getAllTask(): LiveData<List<Task>>


}