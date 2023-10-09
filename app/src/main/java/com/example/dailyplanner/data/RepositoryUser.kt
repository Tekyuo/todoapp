package com.example.dailyplanner.data

import android.content.Context
import com.example.dailyplanner.data.bd.CasesDao
import com.example.dailyplanner.entity.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RepositoryUser  @Inject constructor(private val casesDao: CasesDao,@ApplicationContext private val context: Context) {
    val shared=context.getSharedPreferences("user", Context.MODE_PRIVATE)
   suspend fun signIn(login: String, password: String): User {
       //put user id in shared preferences
       val editor=shared.edit()
       editor.putInt("id", casesDao.takeUser(login, password).id!!)
       editor.apply()
      return  casesDao.takeUser(login, password)
    }

    suspend fun signUp(login: String, password: String, name: String): User {
        casesDao.addUser(User(login = login, password = password, name = name))
        val editor=shared.edit()
        editor.putInt("id", casesDao.takeUser(login, password).id!!)
        editor.apply()
        return  casesDao.takeUser(login, password)
    }

    suspend fun getUserLogIn(): User? {
        val shared=context.getSharedPreferences("user", Context.MODE_PRIVATE)
        val id=shared.getInt("id",0)
        return casesDao.getUser(id)
    }

    suspend fun deleteUserLogIn(){
        val editor=shared.edit()
        editor.putInt("id", 0)
        editor.apply()
    }
}