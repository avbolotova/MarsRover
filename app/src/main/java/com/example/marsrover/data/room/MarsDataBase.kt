package com.example.marsrover.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marsrover.model.Photo

//@Database(entities = [Photo::class], version = 1)
abstract class MarsDataBase : RoomDatabase() {

//    abstract fun getPhotoDao(): MarsDao
//
//    companion object{
//        private var database: MarsDataBase ?= null
//
//        @Synchronized
//        fun getInstance(context: Context): MarsDataBase {
//            return if (database == null) {
//                database = Room
//                    .databaseBuilder(context, MarsDataBase::class.java, "db")
//                    .build()
//                database as MarsDataBase
//            } else {
//                database as MarsDataBase
//            }
//        }
//    }
}