package com.example.marsrover.data

import com.example.marsrover.model.ModelPhoto
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=uundcCnn1JUXbqBaGabUlzAY2W51NI1LbtEAJI0b")
    suspend fun getPhotoMars(): Response<ModelPhoto>
}