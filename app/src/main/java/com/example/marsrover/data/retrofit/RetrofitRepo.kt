package com.example.marsrover.data.retrofit

import com.example.marsrover.data.RetrofitInstance
import com.example.marsrover.model.ModelPhoto
import retrofit2.Response

class RetrofitRepo {
    suspend fun getPhotos(): Response<ModelPhoto> {
        return RetrofitInstance.api.getPhotoMars()
    }
}