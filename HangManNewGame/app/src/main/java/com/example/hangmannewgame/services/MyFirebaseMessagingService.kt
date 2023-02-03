package com.example.hangmannewgame.services

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.hangmannewgame.MainActivity
import com.example.hangmannewgame.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


const val channelID = "notification_channel"
const val channelName = "com.example.hangmannewgame.services"
class MyFirebaseMessagingService : FirebaseMessagingService(){


    //1. Generate notification
    //2. attach notification
    //3. Show notification

    fun OnMessageReceived(remoteMessage: RemoteMessage){
        if(remoteMessage.notification != null){
            generateNotification(remoteMessage.notification!!.title!!,remoteMessage.notification!!.body!!)
        }
    }
        fun generateNotification(title:String,message:String){
            val intent = Intent(this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)


            val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)
            var builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext,
                channelID).setSmallIcon(R.drawable.checkbox).setAutoCancel(true)
                .setVibrate(longArrayOf(1000,1000,1000,100))
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)

            builder = builder.setContent((getRemoteView(title,message)))

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val notificationChannel = NotificationChannel(channelID, channelName,NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)
            }
            notificationManager.notify(0,builder.build())
        }

    fun getRemoteView(title: String, message: String): RemoteViews{
        @SuppressLint("RemoteViewLayout")
        val remoteView = RemoteViews("com.example.hangmannewgame.services",R.layout.activity_main)

        remoteView.setTextViewText(R.id.title,title)
        remoteView.setTextViewText(R.id.description,message)
        remoteView.setImageViewResource(R.id.app_logo,R.drawable.checkbox)

        return remoteView
    }
}