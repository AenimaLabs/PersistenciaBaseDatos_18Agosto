package com.example.persistenciabasedatos_18agosto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistenciabasedatos_18agosto.model.Task

@Database(entities = arrayOf(Task::class), version = 0, exportSchema = false)
abstract class TaskDataBase : RoomDatabase(){


    abstract fun getTaskDAO(): TaskDAO

    companion object {
        @Volatile
        private var INSTANCE: TaskDataBase? = null

        fun getDataBase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database").build()
                INSTANCE = instance
                return instance

            }


        }
    }
}