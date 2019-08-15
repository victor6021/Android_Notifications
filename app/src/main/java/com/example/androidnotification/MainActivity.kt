package com.example.androidnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidnotification.util.NotificationGenerator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 97
        const val STRING_KEY = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_notification.setOnClickListener {
            NotificationGenerator.NotificationData(this)
        }
    }
}