package com.sds.nutrifysports

import android.app.Application
import com.nutrifysports.di.initializeKoin
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize
import org.koin.android.ext.koin.androidContext

class NutriFyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin(
            config = {
                androidContext(this@NutriFyApp)
            }
        )
        Firebase.initialize(this)

    }
}
