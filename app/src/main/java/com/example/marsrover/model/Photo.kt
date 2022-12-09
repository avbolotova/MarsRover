package com.example.marsrover.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.io.Serializable

@Entity(tableName = "photo_mars")
data class Photo(
    @PrimaryKey(autoGenerate = true)
    var numId: Int = 1,
//    val camera: Camera,
    val earth_date: String,
    val id: Int,
    val img_src: String,
//    val rover: Rover,
    val sol: Int
) : Serializable