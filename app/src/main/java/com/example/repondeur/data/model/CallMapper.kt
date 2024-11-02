package com.example.repondeur.data.model

import com.example.repondeur.data.local.entities.CallRecord

fun CallRecord.toDomainModel():Call{
    return Call(
        id = this.id,
        callerName = this.callerName,
        callerNumber = this.callerNumber,
        timestamp = this.timestamp,
        audioFilePath = this.audioFilePath
    )
}

fun Call.toEntity():CallRecord{
    return CallRecord(
        id = this.id,
        callerName = this.callerName,
        callerNumber = this.callerNumber,
        timestamp = this.timestamp,
        audioFilePath = this.audioFilePath
    )
}
