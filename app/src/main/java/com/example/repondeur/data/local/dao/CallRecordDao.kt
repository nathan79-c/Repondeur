package com.example.repondeur.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.query
import androidx.room.Delete
import com.example.repondeur.data.local.entities.CallRecord

@Dao
interface CallRecordDao{
    @insert
    suspend fun insert(callRecord:CallRecord):long
    @Query("SELECT * FROM call_records ORDER BY timestamp DESC")

    suspend fun getAllCallRecords(): List<CallRecord>

    @Delete
    suspend fun delete(callRecord: CallRecord)
}