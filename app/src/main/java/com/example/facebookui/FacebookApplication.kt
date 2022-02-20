package com.example.facebookui

import android.app.Application
import android.util.Log

class FacebookApplication : Application() {

    private val TAG: String = FacebookApplication::class.java.simpleName.toString()

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }
}
