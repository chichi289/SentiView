package com.chichi289.sentiview.domain.repository

import com.chichi289.sentiview.data.models.Todo
import kotlinx.coroutines.flow.Flow

interface ToDoDataSource {

    fun getTodos(): Flow<List<Todo>>

}