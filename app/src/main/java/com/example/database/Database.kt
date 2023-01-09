package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Info::class], version = 2)
abstract class Database : RoomDatabase(){
    abstract fun infoDao():InfoDao
}