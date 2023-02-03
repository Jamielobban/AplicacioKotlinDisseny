package com.example.hangmannewgame



import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity



import com.example.hangmannewgame.databinding.ActivityMainBinding
import android.content.Intent


import android.widget.Toast

import com.example.hangmannewgame.SplashScreenActivity.Companion.prefs
import com.example.hangmannewgame.services.BackgroundSoundService




class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.Theme_HangManNewGame_AppBarOverlay)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initUI()
        checkUserValues()
        //Go to settings
        binding.settingsButton.setOnClickListener {
            val intent = Intent(this@MainActivity, OptionsActivity::class.java)
            startActivity(intent)

            val intentS = Intent(this@MainActivity, BackgroundSoundService::class.java)
            intentS.putExtra("audioIndex", "4")
            startService(intentS)
        }

        // Go to game
        binding.playButton.setOnClickListener{

            if(binding.nameChange.text.toString().isNotEmpty()){
                val intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)

                val intentS = Intent(this@MainActivity, BackgroundSoundService::class.java)
                intentS.putExtra("audioIndex", "1")
                startService(intentS)
            }
            else{
                //Name null check soo ranking doesnt bust
                Toast.makeText(this@MainActivity,"Please write a name and save the changes", Toast.LENGTH_SHORT).show()
            }
        }
        // Go to ranking
        binding.rankingButton.setOnClickListener{
            val intent = Intent(this@MainActivity, RankingActivity::class.java)
            startActivity(intent)

            val intentS = Intent(this@MainActivity, BackgroundSoundService::class.java)
            intentS.putExtra("audioIndex", "4")
            startService(intentS)
        }

    }


    fun initUI(){
        binding.saveChanges.setOnClickListener{ accessToDetail()
        }

    }
    fun accessToDetail(){
        // Saves the name to a player pref
        if(binding.nameChange.text.toString().isNotEmpty()){
            prefs.saveName(binding.nameChange.text.toString())
            Toast.makeText(this@MainActivity,"Name Saved Correctly", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@MainActivity,"Name cant be void", Toast.LENGTH_SHORT).show()
        }

    }

    fun checkUserValues(){

        // Gets score and name
        if(prefs.getName().isNotEmpty()){
            binding.nameChange.setText(prefs.getName())
        }
        if(prefs.getScore() != 0){
            //Toast.makeText(this@MainActivity,"just a check", Toast.LENGTH_SHORT).show()
            binding.highscore.setText("Highscore + ${prefs.getScore()}")
        }
        else{

            // If score not saved
            binding.highscore.setText("Highscore 0")
        }
    }

}



