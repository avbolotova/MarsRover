package com.example.marsrover.data.retrofit

import com.example.marsrover.data.RetrofitInstance
import com.example.marsrover.model.ModelPhoto
import com.example.marsrover.model.Photo
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import org.jetbrains.annotations.Async
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class RetrofitRepo {
    suspend fun getPhotos(): Response<ModelPhoto> {
        return RetrofitInstance.api.getPhotoMars()
    }
}
