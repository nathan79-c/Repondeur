package com.example.repondeur.data.model.repository

import com.example.repondeur.data.local.LocalDataSource
import com.example.repondeur.data.model.Call
import com.example.repondeur.data.model.toDomainModel
import com.example.repondeur.data.model.toEntity

class CallRepository(private val LocalDataSource: LocalDataSource){

    // obtenir les appels manquer
    suspend fun getAllCalls():List<Call>{
        return LocalDataSource.getCallRecords().map{it.toDomainModel()}
    }

    // Enregistrer un nouvel apppel manque

    suspend fun  saveCall(call:Call){
        LocalDataSource.saveCallRecord(call.toEntity())
    }

    // supprimer un appel manquer

    suspend fun  deleteCall(call: Call){
        LocalDataSource.deleteCallRecord(call.toEntity())
    }
}