package com.adam.app.myfirstkotlin

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast

class Utils {
    companion object {
        val BUNDLE_KEY = "data"
        val RADIO_KEY = "radio.key"
        val RESLUT_CODE = 0x1234
        val REQEUST_CODE = 0x2468

        fun showDialog(ctx:Context, str1:String, str2:String) {
            var alert_dialog = AlertDialog.Builder(ctx)
            alert_dialog.setTitle(str1)
            alert_dialog.setMessage(str2)
            alert_dialog.setPositiveButton("Ok", {_, _ ->  println("Ok test")})
            val dialog = alert_dialog.create()
            // Show dialog
            dialog.show()
        }

        fun showCustToast(ctx:Context, msg:String) {
            val toast = Toast(ctx)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            // Get toast layout
            val toast_layout = LayoutInflater.from(ctx).inflate(R.layout.toast_view, null)
            val toast_info = toast_layout.findViewById<TextView>(R.id.toast_info)
            toast_info.text = msg
            // Add view
            toast.view = toast_layout
            // Show
            toast.show()
        }

        fun showSnack(v: View, msg: String) {
            val snackBar = Snackbar.make(v, msg, Snackbar.LENGTH_LONG).setAction("Press me", {
                v.setBackgroundColor(Color.GRAY)
            }).show()
        }

        fun showToast(ctx:Context, msg:String) {
            Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show()
        }
    }
}