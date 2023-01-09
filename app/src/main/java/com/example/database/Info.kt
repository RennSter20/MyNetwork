package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room

@Entity
data class Info(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name="first_name") val firstName: String?,
    @ColumnInfo(name="last_name") val lastName: String?,
    @ColumnInfo(name="phone_number") val phoneNumber: String?,
    @ColumnInfo(name="address") val address:String?,
    @ColumnInfo(name="work") val work:String?,
    @ColumnInfo(name="education") val education:String?,
    @ColumnInfo(name="customFirst") val customFirst:String?,
    @ColumnInfo(name="customSecond") val customSecond:String?,
    @ColumnInfo(name="other") val other:String?
)
