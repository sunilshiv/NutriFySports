package com.sds.nutrifysports

import android.app.Application
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize

class NutriFyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Firebase.initialize(this)

    }
}
