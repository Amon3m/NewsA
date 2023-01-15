package com.m3.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_main)

        Handler(Looper.getMainLooper()).postDelayed({
            startHomeActivity()}, 2000)
    }

    private fun startHomeActivity() {
        intent= Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}



