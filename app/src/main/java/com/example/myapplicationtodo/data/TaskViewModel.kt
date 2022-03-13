package com.example.myapplicationtodo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) :AndroidViewModel(application){
    private  val realAllData : LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDAO = TaskDatabase.getDatabase(application).taskDAO()
        repository = TaskRepository(taskDAO)
        realAllData = repository.readalldata

    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }
}
