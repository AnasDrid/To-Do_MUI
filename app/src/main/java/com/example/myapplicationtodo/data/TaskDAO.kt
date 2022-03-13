package com.example.myapplicationtodo.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDAO {
    @Query ("SELECT * from Tasks ORDER BY uid ASC")
    fun getall():LiveData<List<Task>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task:Task)
    @Delete
    fun delete(Task:Task)
}