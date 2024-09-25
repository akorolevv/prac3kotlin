package com.example.prac3kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel()
{

    // Приватная изменяемая LiveData для навигации ко второму фрагменту
    private val _navigateToSecond = MutableLiveData<Boolean>()

    // Публичная неизменяемая LiveData для наблюдения за навигацией ко второму фрагменту
    val navigateToSecond: LiveData<Boolean> = _navigateToSecond


    // Приватная изменяемая LiveData для навигации к третьему фрагменту
    private val _navigateToThird = MutableLiveData<Boolean>()

    // Публичная неизменяемая LiveData для наблюдения за навигацией к третьему фрагменту
    val navigateToThird: LiveData<Boolean> = _navigateToThird


    // Функция для установки флага навигации ко второму фрагменту
    fun onNavigateToSecond() {
        _navigateToSecond.value = true
    }

    // Функция для установки флага навигации к третьему фрагменту
    fun onNavigateToThird() {
        _navigateToThird.value = true
    }

    // Функция для сброса флагов навигации после выполнения навигации
    fun onNavigationComplete() {
        _navigateToSecond.value = false
        _navigateToThird.value = false
    }
}