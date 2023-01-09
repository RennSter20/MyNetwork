package com.example.database

import androidx.room.*

@Dao
interface InfoDao {
    @Query("SELECT * FROM info")
    fun getAll(): List<Info>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg users: Info)

    @Delete
    fun delete(user: Info)
}