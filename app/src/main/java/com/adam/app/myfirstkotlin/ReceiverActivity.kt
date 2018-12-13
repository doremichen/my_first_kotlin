package com.adam.app.myfirstkotlin

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_receiver.*

class ReceiverActivity : AppCompatActivity() {


    private val mUIHandler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val data = msg.data
            val getResponse = data.getString("msg.key")

            // Update UI
            ReceiverInfo.text = getResponse

        }
    }
    private var mReceiver: MyReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        // register receiver
        mReceiver = MyReceiver(mUIHandler)
        val intentFilter = IntentFilter()
        intentFilter.addAction("send.broadcast")
        registerReceiver(mReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mReceiver)
    }

    fun onBroadcast(view: View) {
        val it = Intent("send.broadcast")
        it.putExtra("receiver.key", "Hello receiver")
        sendBroadcast(it)
    }

    fun onExit(view: View) {
        finish()
    }
}
