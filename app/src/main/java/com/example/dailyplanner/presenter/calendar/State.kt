package com.example.dailyplanner.presenter.calendar

import com.example.dailyplanner.entity.CaseDB
import com.example.dailyplanner.entity.CaseHour
import com.example.dailyplanner.entity.User

sealed interface State{
    data class Succses(val dayCases:List<CaseHour> ,val user: User):State//успех
    object Loading:State//загрузка
    data class Error(val error:String):State//ошибка
    object SuccsesOut:State//успех выхода
}