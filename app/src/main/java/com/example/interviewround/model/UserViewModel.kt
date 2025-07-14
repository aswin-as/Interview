package com.example.interviewround.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewround.data.Comment
import com.example.interviewround.data.RetrofitInstance
import com.example.interviewround.data.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val _comments = MutableStateFlow<List<Comment>> (emptyList())
    val users: StateFlow<List<Comment>> = _comments

    init {
        fetchComments()
    }



    private fun fetchComments() {
       viewModelScope.launch {
           try {
               val response = RetrofitInstance.api.getComments()
                _comments.value = response.comments
           }catch (e: Exception) {
               Log.e("UserViewModel", "Error fetching comments", e)
           }
       }
    }
}