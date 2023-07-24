package com.chichi289.sentiview.data.repository

import com.chichi289.sentiview.domain.repository.ToDoDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val toDoDataSource: ToDoDataSource
) {

    fun getTodos() = toDoDataSource.getTodos()

}