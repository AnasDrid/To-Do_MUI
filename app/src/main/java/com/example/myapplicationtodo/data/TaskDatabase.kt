package com.example.myapplicationtodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Task::class), version = 1)
abstract class TaskDatabase :RoomDatabase() {
    abstract fun taskDAO():TaskDAO

    companion object {
        @Volatile
        private var INSTANCE : TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase{
            val tempInstance= INSTANCE
            if(tempInstance !=null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "Tasks"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}