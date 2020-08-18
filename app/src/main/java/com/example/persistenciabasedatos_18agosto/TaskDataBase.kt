package com.example.persistenciabasedatos_18agosto

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Task::class), version = 0, exportSchema = false)
abstract class TaskDataBase : RoomDatabase(){


    abstract fun getTaskDAO():TaskDAO
}