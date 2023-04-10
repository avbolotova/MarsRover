package com.example.marsrover

import android.app.Application
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class MarsAndroidApp : Application() {


    override fun onCreate() {
        super.onCreate()

        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if(!task.isSuccessful) {
                return@addOnCompleteListener
        }
            val token = task.result
            println("!!!")
            println("TAGToken - $token")
            Log.i("TAG", "Token - $token");
            Log.e("TAG", "Token - $token")
        }
    }
}
