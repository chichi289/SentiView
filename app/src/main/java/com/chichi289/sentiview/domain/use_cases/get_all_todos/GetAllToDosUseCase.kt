package com.chichi289.sentiview.domain.use_cases.get_all_todos

import com.chichi289.sentiview.data.models.Todo
import com.chichi289.sentiview.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllToDosUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<Todo>> {
        return repository.getTodos()
    }
}