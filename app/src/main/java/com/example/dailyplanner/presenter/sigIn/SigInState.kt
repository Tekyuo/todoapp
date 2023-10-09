package com.example.dailyplanner.presenter.sigIn

import com.example.dailyplanner.entity.User

sealed class SigInState {
    object Loading : SigInState()
    object UserAuth : SigInState()
    data class Success(val user:User) : SigInState()
    data class Error(val error: String) : SigInState()
}