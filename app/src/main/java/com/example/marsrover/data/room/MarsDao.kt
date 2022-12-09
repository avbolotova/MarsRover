package com.example.marsrover.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.marsrover.model.Photo

@Dao
interface MarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Photo)

    @Delete
    suspend fun delete(item: Photo)

    @Query("SELECT * from photo_mars")
    fun getAllPhoto() : LiveData<List<Photo>>
}