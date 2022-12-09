package com.example.marsrover.view.detailed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrover.REALIZATION
import com.example.marsrover.model.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailedViewModel : ViewModel() {

    fun insert(item: Photo, onSuccess:() -> Unit) = viewModelScope.launch (Dispatchers.IO) {
        REALIZATION.insertPhoto(item) {
            onSuccess()
        }
    }

    fun delete(item: Photo, onSuccess:() -> Unit) = viewModelScope.launch (Dispatchers.IO) {
        REALIZATION.deletePhoto(item) {
            onSuccess()
        }
    }
}