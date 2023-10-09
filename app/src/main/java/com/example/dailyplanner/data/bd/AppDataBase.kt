package com.example.dailyplanner.data.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dailyplanner.entity.CaseDB
import com.example.dailyplanner.entity.User

@Database(entities =[CaseDB::class, User::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase(){
    abstract fun photoDao():CasesDao  //метод для создания экзампляра базы данных
}