package com.example.exam6

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val _userLiveData: LiveData<List<Article>> = UserDatabase.db.userDao().getAll()

    fun write(
        title: String?,
        description: String?,
        url: String?
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                UserDatabase.db.userDao()
                    .insert(Article(title,description,url))
            }
        }
    }

    fun delete(article: Article){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                UserDatabase.db.userDao().delete(article)
            }
        }
    }

    fun update(article: Article){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                UserDatabase.db.userDao().update(article)
            }
        }
    }
}