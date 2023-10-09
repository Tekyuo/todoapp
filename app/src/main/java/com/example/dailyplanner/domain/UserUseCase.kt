package com.example.dailyplanner.domain

import com.example.dailyplanner.data.RepositoryUser
import com.example.dailyplanner.entity.User
import javax.inject.Inject

class UserUseCase @Inject constructor(private val repositoryUser: RepositoryUser) {
    suspend fun signIn(login: String, password: String): User {
       return repositoryUser.signIn(login, password)
    }

    suspend fun signUp(login: String, password: String, name: String): User {
      return  repositoryUser.signUp(login, password, name)
    }

    suspend fun getUserLogIn(): User? {
        return repositoryUser.getUserLogIn()
    }

    suspend fun deleteUserLogIn(){
        repositoryUser.deleteUserLogIn()
    }
}