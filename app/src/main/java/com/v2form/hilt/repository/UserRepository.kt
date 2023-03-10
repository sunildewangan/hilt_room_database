package com.v2form.hilt.repository

import com.v2form.hilt.dao.UserDao
import com.v2form.hilt.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(val userDao: UserDao) {

    val getUserData:Flow<List<User>> = userDao.getUser()

    suspend fun insert(user:User) = withContext(Dispatchers.IO){
        userDao.insert(user)
    }
}