package com.example.androidnotification.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.androidnotification.MainActivity

object NotificationGenerator {
    fun NotificationData(context: Context){
        val contentIntent = Intent(context, MainActivity::class.java)
        val pendingContentIntent = PendingIntent.getActivity(context,0,contentIntent,PendingIntent.FLAG_ONE_SHOT)

        val channelId = "${context.packageName}.NotificationDemo"
        val notifyManage = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = "Notification"
                val importance = NotificationManager.IMPORTANCE_HIGH
                val description = "victor's first attempt"

                val channel = NotificationChannel(channelId, name, importance)
                channel.description = description

                notifyManage.createNotificationChannel(channel)
            }
            val notifyBuilder = NotificationCompat.Builder(context, channelId)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setContentTitle("Victor is")
                .setContentText("DOING IT!")
                .setSmallIcon(android.R.drawable.arrow_down_float)
                .setColor(ContextCompat.getColor(context, android.R.color.holo_orange_light))
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
            notifyManage.notify(MainActivity.NOTIFICATION_ID, notifyBuilder.build())
        }
    }
