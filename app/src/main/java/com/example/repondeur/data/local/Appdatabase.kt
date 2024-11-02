package com.example.repondeur.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entitties =
[CallRecord::Class], version = 1)
abstract class Appdatabase:
        RoomDatabase(){
            abstract fun callRecordDao():
                    callRecordDao
        }