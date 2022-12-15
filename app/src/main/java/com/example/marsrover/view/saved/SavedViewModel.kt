package com.example.marsrover.view.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrover.REALIZATION
import com.example.marsrover.model.Photo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SavedViewModel : ViewModel() {

    fun getAllSavedPhoto(): LiveData<List<Photo>> {
        return REALIZATION.allPhoto
    }

    fun deleteAllSavedPhoto(item: Photo) {
        viewModelScope.launch {
            REALIZATION.deletePhoto(item) {}
        }
    }

}