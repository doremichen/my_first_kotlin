package com.adam.app.myfirstkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message

class MyReceiver(private val mHanlde: Handler) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == "send.broadcast") {
            val getStr = intent.getStringExtra("receiver.key")
            // Update UI
            val msg = Message.obtain(mHanlde)
            val data = Bundle()
            data.putString("msg.key", "$getStr: I got it broadcast!!!")
            msg.data = data

            mHanlde.sendMessage(msg)

        }
    }
}
