package edu.utez.mx.restaurante.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import edu.utez.mx.restaurante.data.repository.PlatilloRepository

class ViewModelFactory(private val repository: PlatilloRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(PlatilloListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PlatilloListViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(CreateDishViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateDishViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(EditDishViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            val savedStateHandle = extras.createSavedStateHandle()
            return EditDishViewModel(repository, savedStateHandle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}