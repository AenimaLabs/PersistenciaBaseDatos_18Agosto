package com.example.persistenciabasedatos_18agosto.database

import androidx.room.*
import com.example.persistenciabasedatos_18agosto.model.Task

@Dao
interface TaskDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Insert
    fun inserMultipleTask (list: List<Task>)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteOneTask (task: Task)

    @Query ("Select * FROM task_table ORDER BY idTask ASC")
    fun getAllTask(): List<Task>


}