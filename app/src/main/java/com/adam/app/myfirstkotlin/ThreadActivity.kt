package com.adam.app.myfirstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    private val UPDATE_UI = 1

    private val STOP_UPDATE_UI = 2

    private var mStop = false

    private lateinit var mWorkTask:Thread


    // Create UI handler
    val mHandler = object: Handler() {
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when (msg?.what) {
                UPDATE_UI -> {
                    show_thread_state.text = "Running...."
                }
                STOP_UPDATE_UI -> {
                    show_thread_state.text = "Stop..."
                    Thread.sleep(1000L)
                    finish()
                }

            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        stop_thread.isEnabled = false
    }

    fun Start(v:View) {

        mWorkTask = Thread {
            run {
                while (mStop == false) {
                    Thread.sleep(1000L)
                    val msg = Message()
                    msg.what = UPDATE_UI
                    mHandler.sendMessage(msg)
                }

                // Stop update UI
                val msg = Message()
                msg.what = STOP_UPDATE_UI
                mHandler.sendMessage(msg)
            }
        }

        mWorkTask.start()

        stop_thread.isEnabled = true
        start_thread.isEnabled = false
    }

    fun Stop(v: View) {

        when (mWorkTask.isAlive) {
            true -> mStop = true
        }

        stop_thread.isEnabled = false
        start_thread.isEnabled = true
    }
}
