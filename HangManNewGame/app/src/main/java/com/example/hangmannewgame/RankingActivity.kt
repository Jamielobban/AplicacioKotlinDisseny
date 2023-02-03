package com.example.hangmannewgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hangmannewgame.databinding.ActivityRankingBinding
import com.example.hangmannewgame.services.BackgroundSoundService
import com.google.firebase.database.*

class RankingActivity : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<UserInfo>
    private lateinit var binding: ActivityRankingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Binds recycler view
        userRecyclerView = binding.rankingList

        // Linear layout
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        //SET SIZE
        userRecyclerView.setHasFixedSize(true)
        // Set array of what its going to be full of
        userArrayList = arrayListOf<UserInfo>()
        gerUserData()
        //Back button
        binding.backToHome.setOnClickListener{
            val intent = Intent(this@RankingActivity, MainActivity::class.java)
            startActivity(intent)

            val intentS = Intent(this@RankingActivity, BackgroundSoundService::class.java)
            intentS.putExtra("audioIndex", "4")
            startService(intentS)
        }


    }

    private fun gerUserData() {
        // Sets the database direction
        dbref = FirebaseDatabase.getInstance("https://hangmannewgame-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("UserInfo")

        // Makes an object listener for each node and stores its info in user
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(userSnapshot in snapshot.children){

                        val user = userSnapshot.getValue(UserInfo::class.java)
                        // Adds the user to the array
                        userArrayList.add(user!!)
                    }
                    userRecyclerView.adapter = RankingAdapter(userArrayList)
                }

            }

            override fun onCancelled(error: DatabaseError) {

                Toast.makeText(this@RankingActivity,"Failed", Toast.LENGTH_SHORT).show()
            }

        })


    }
}