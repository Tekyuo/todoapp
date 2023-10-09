package com.example.dailyplanner.presenter.sigIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyplanner.domain.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SigInViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {
    private val _state= MutableStateFlow<SigInState>(SigInState.Loading)
    val state=_state.asStateFlow()

    fun signIn(login: String, password: String) {
        viewModelScope.launch {
            _state.value=SigInState.Loading
         val user=   userUseCase.signIn(login, password)
            _state.value=SigInState.Success(user)
        }
    }

    fun signUp(login: String, password: String, name: String) {
        viewModelScope.launch {
            _state.value=SigInState.Loading
            val user=   userUseCase.signUp(login, password, name)
            _state.value=SigInState.Success(user)
        }
    }

    fun isAuth() {
        viewModelScope.launch {
            _state.value=SigInState.Loading
            val userLog=   userUseCase.getUserLogIn()
            if(userLog!=null)
                _state.value=SigInState.UserAuth
            else
                _state.value=SigInState.Error("error")
        }
    }
}