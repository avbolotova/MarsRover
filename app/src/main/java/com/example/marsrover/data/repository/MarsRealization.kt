package com.example.marsrover.data.repository

import androidx.lifecycle.LiveData
import com.example.marsrover.data.room.MarsDao
import com.example.marsrover.model.Photo
import javax.inject.Inject

class MarsRealization @Inject constructor (private val MarsDao: MarsDao) : MarsRepo {
    override val allPhoto: LiveData<List<Photo>>
        get() = MarsDao.getAllPhoto()

    override suspend fun insertPhoto(item: Photo, onSuccess: () -> Unit) {
        MarsDao.insert(item)
        onSuccess()
    }

    override suspend fun deletePhoto(item: Photo, onSuccess: () -> Unit) {
        MarsDao.delete(item)
        onSuccess
    }
}