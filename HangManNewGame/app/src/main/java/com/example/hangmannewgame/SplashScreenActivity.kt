package com.example.hangmannewgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.hangmannewgame.databinding.ActivitySplashScreenBinding
import com.example.hangmannewgame.services.BackgroundSoundService
import com.example.hangmannewgame.services.MyFirebaseMessagingService
import com.example.hangmannewgame.services.Prefs


class SplashScreenActivity : AppCompatActivity() {


    // Declare the companion object of prefs
    companion object{
        lateinit var prefs: Prefs
    }

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Start audio
        val intentS = Intent(this@SplashScreenActivity, BackgroundSoundService::class.java)
        intentS.putExtra("audioIndex", "0")
        startService(intentS)

        // Start noti service
        val intent2 = Intent(this@SplashScreenActivity, MyFirebaseMessagingService::class.java)
        startService(intent2)

        // Start playerprefs
        prefs = Prefs(applicationContext)
        // Null check
        if(prefs.getName() == "" || prefs.getName() == null){
            prefs.saveName("Guest")
        }

        // Timer just to get to next screen
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

        }
    }
