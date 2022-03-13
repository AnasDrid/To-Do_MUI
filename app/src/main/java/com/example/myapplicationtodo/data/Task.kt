package com.example.myapplicationtodo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "Tasks")
data class Task (
    @PrimaryKey val uid:Int,
    val title:String,
    val criticality:criticality,
    val duedate:LocalDate,
    val status:Status,

)