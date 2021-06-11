package com.example.exam6

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDAO {
    @Query("SELECT * FROM article")
    fun getAll(): LiveData<List<Article>>

    @Insert
    suspend fun insert(user: Article)

    @Delete
    suspend fun delete(user: Article)

    @Update
    suspend fun update(user: Article)
}