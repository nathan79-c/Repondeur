package com.example.repondeur.data.local

import com.example.repondeur.data.local.dao.CallRecordDao
import com.example.repondeur.data.local.entities.CallRecord

class LocalDataSource(private val callRecordDao: CallRecordDao){
    suspend fun saveCallRecord(callRecord:CallRecord){
        callRecordDao.insert(callRecord)
    }

    suspend fun getCallRecords():List<CallRecord>{
        return callRecordDao.getAllCallRecords()
    }

    suspend fun deleteCallRecord(callRecord: CallRecord){
        callRecordDao.delete(callRecord)
    }
}