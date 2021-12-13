package com.example.jetsellbook.viewmodel

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsellbook.data.ApiService
import com.example.jetsellbook.model.BooksModel
import kotlinx.coroutines.delay
import com.example.jetsellbook.R
import com.example.jetsellbook.model.BooksDbModel

import com.example.jetsellbook.model.LoginState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //search

    private  val _book = mutableStateListOf<BooksDbModel>()
    var errorMessages: String by mutableStateOf("Lỗi tìm kiếm")
    val books: SnapshotStateList<BooksDbModel>
        get() = _book

    fun searchBooks(name: String) {

    }


    val state: MutableState<LoginState> = mutableStateOf(LoginState())

    private var _accountEntry = MutableLiveData(LoginState())
    val accountEntry: LiveData<LoginState> = _accountEntry
    var emails by mutableStateOf("")

    fun addlogin(email: String, password: String) {
        val errorMessage = if(email.isBlank() || password.isBlank()) {
            R.string.error_input_empty
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            R.string.error_not_a_valid_email
        } else if(email != "hoangtrungquan@gmail.com" || password != "password"){
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
            emails=state.value.email
            JetSellBookRouter.navigateTo(Screen.HomePage)
        }
    }
    fun hideErrorDialog() {
        state.value = state.value.copy(
            errorMessage = null
        )
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