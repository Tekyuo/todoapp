package com.example.dailyplanner.presenter.sigIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class SigInFactory @Inject constructor(private val viewModel: SigInViewModel):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel as T
    }
}