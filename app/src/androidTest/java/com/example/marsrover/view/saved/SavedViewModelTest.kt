package com.example.marsrover.view.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrover.REALIZATION
import com.example.marsrover.model.Photo
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SavedViewModelTest : ViewModel() {


    @Test
    fun getAllSavedPhoto() {
    }

    @Test
    suspend fun deleteAllSavedPhoto(item: Photo) {
        viewModelScope.apply {
            REALIZATION.deletePhoto(item) {}
        }
    }
}


//class SavedViewModel : ViewModel() {
//
//    fun getAllSavedPhoto(): LiveData<List<Photo>> {
//        return REALIZATION.allPhoto
//    }
//
//    fun deleteAllSavedPhoto(item: Photo) {
//        viewModelScope.launch {
//            REALIZATION.deletePhoto(item) {}
//        }
//    }
//
//}