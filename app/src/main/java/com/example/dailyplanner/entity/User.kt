package com.example.dailyplanner.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "User")
@Parcelize
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "password")
    var password: String,
):Parcelable