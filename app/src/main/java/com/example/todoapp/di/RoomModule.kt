package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.db.TodoDao
import com.example.todoapp.db.TodoDataBase
import com.example.todoapp.utility.DataBaseConst.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    @Singleton
    fun getTodoDataBase(@ApplicationContext context: Context): TodoDataBase {
        return Room.databaseBuilder(
            context,
            TodoDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun getDao(todoDataBase: TodoDataBase): TodoDao {
        return todoDataBase.getDao()
    }
}