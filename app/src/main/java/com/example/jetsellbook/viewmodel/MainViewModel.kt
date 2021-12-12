package com.example.jetsellbook.viewmodel

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsellbook.data.ApiService
import com.example.jetsellbook.model.BooksModel
import kotlinx.coroutines.delay
import com.example.jetsellbook.R
import com.example.jetsellbook.model.LoginState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    val state: MutableState<LoginState> = mutableStateOf(LoginState())
    fun login(email: String, password: String) {
        val errorMessage = if(email.isBlank() || password.isBlank()) {
            R.string.error_input_empty
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            R.string.error_not_a_valid_email
        } else if(email != "user@gmail.com" || password != "password"){
            R.string.error_invalid_credentials
        } else null
        errorMessage?.let {
            state.value = state.value.copy(errorMessage = it)
            return
        }
        viewModelScope.launch {
            state.value = state.value.copy(displayProgressBar = true)
            delay(3000)
            state.value = state.value.copy(email = email, password = password)
            state.value = state.value.copy(displayProgressBar = false)
            state.value = state.value.copy(successLogin = true)
        }
    }

    // Rest api
    private  val _bookList = mutableStateListOf<BooksModel>()
    var errorMessage: String by mutableStateOf("")
    val bookList:List<BooksModel>
        get() = _bookList


    fun getBookList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstansce()
            try{
                _bookList.clear()
                _bookList.addAll(apiService.getBooks())
            }catch (e: Exception){
                errorMessage= e.message.toString()
            }
        }
    }

}