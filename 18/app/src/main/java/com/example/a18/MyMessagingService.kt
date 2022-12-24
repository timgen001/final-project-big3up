package com.example.a18

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
class MyMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("onNewToken", token)
    }
    override fun onMessageReceived(msg: RemoteMessage) {
        super.onMessageReceived(msg)
        msg.data.entries.forEach {
            Log.e("data", "key:${it.key}, value:${it.value}")
        }
    }
}