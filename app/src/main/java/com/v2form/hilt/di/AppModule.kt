package com.v2form.hilt.di

import android.content.Context
import androidx.room.Room
import com.v2form.hilt.dao.UserDao
import com.v2form.hilt.database.UserDatabase
import com.v2form.hilt.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java,"userDataBase").build()


    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase):UserDao =userDatabase.userDao()


    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)

}