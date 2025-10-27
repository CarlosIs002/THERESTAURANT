package edu.utez.mx.restaurante.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateUserViewModel: ViewModel() {
    var password = mutableStateOf("")
    var mail = mutableStateOf("")
    var username = mutableStateOf("")
    var phone = mutableStateOf("")
    var createError = mutableStateOf("")

    fun create(onSuccess: () -> Unit) {
        if (password.value ==""&&mail.value==""&&username.value == ""&&phone.value==""){
            createError.value = "Algun campo esta vacio"
        }else{
            createError.value = ""
            onSuccess()
        }
    }
}