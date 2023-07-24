package com.chichi289.sentiview.data.repository

import android.util.Log
import com.chichi289.sentiview.data.models.Todo
import com.chichi289.sentiview.data.services.TodoApi
import com.chichi289.sentiview.domain.repository.ToDoDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ToDoDataSourceImpl(
    private val todoApi: TodoApi
) : ToDoDataSource {
    override fun getTodos(): Flow<List<Todo>> {
        return flow {
            Log.e("CHIRAG", "start flow")
            val result = todoApi.getTodos()
            Log.e("CHIRAG", "result:$result")
            emit(result)
            Log.e("CHIRAG", "end flow")
        }
    }
}