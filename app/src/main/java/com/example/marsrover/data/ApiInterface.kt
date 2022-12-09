package com.example.marsrover.data

import com.example.marsrover.model.ModelPhoto
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=xNOgrUW7h2YN64QVx54wQZ6uBPRGy0QTHqCsyF2Z")
    suspend fun getPhotoMars(): Response<ModelPhoto>
}