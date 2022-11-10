package com.example.marsrover.view.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marsrover.REALIZATION
import com.example.marsrover.data.repository.MarsRealization
import com.example.marsrover.data.retrofit.RetrofitRepo
import com.example.marsrover.data.room.MarsDataBase
import com.example.marsrover.model.ModelPhoto
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (application: Application): AndroidViewModel(application) {
    val repo = RetrofitRepo()
    val myMovies: MutableLiveData<Response<ModelPhoto>> = MutableLiveData()
    val context = application

    fun getPhotos(){
        viewModelScope.launch {
            myMovies.value = repo.getPhotos()
        }
    }
//    fun initDatabase(){
//        val daoPhoto = MarsDataBase.getInstance(context).getPhotoDao()
//        REALIZATION = MarsRealization(daoPhoto)
//    }
}