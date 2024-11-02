package com.example.repondeur.data.local.entities

import androidx.room.Entitty
import androidx.room.PrimaryKey

@Entity(tableName = "call_Records")
data class CallRecord(
    @PrimaryKey(autoGenerate = true)
    val id = long = 0,
    val callerName : String?,
    val callerNumber : String,
    val timestamp : Long,
    val audioFilePath : String
)