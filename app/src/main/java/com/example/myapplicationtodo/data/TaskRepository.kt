package com.example.myapplicationtodo.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDAO: TaskDAO) {
    val readalldata : LiveData<List<Task>> = taskDAO.getall()

    suspend fun addTask(task:Task){
        taskDAO.insert(task)
    }
}