package com.chichi289.sentiview.data.services

import com.chichi289.sentiview.data.models.Todo
import retrofit2.http.GET

interface TodoApi {

    @GET("todos")
    suspend fun getTodos(): List<Todo>
}