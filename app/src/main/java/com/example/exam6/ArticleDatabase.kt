package com.example.exam6

import androidx.room.Room

object UserDatabase {
    val db:AppDatabase by lazy {
        Room.databaseBuilder(
            App.context!!,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}