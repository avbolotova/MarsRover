package com.example.marsrover.view.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainViewModelTest() {
    val mainViewModel: MainViewModel = MainViewModel(application = Application())

    @Test
    fun getPhotosTest(){
        mainViewModel.getPhotos()
    }
}
