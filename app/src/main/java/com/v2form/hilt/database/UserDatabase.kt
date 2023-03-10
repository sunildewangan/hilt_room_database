package com.v2form.hilt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.v2form.hilt.dao.UserDao
import com.v2form.hilt.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao():UserDao
}