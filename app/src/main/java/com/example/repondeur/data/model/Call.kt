package com.example.repondeur.data.model

data class Call (
    val id :Long,
     val callerName: String?,
     val callerNumber : String,
     val timestamp: Long,
     val audioFilePath :String
)