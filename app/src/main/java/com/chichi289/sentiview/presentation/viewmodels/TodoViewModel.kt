package com.chichi289.sentiview.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.chichi289.sentiview.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    val getTodos = useCases.getAllToDosUseCase

}