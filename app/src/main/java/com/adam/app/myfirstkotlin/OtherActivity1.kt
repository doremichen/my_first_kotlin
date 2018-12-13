package com.adam.app.myfirstkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_other_activity1.*

class OtherActivity1 : AppCompatActivity() {

    private fun sendClicked() = View.OnClickListener {
        var checkId = RG_1.checkedRadioButtonId

        val data = Bundle()

        when (checkId) {
            R.id.radioBtn1 -> {
                data.putString(Utils.RADIO_KEY, "iTem1")
            }
            R.id.radioBtn2 -> {
                data.putString(Utils.RADIO_KEY, "iTem2")
            }
            R.id.radioBtn3 -> {
                data.putString(Utils.RADIO_KEY, "iTem3")
            }
        }

        val newIntent = Intent()
        newIntent.putExtra(Utils.BUNDLE_KEY, data)
        setResult(Utils.RESLUT_CODE, newIntent)

        // close UI
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_activity1)

        val data = intent.getBundleExtra(Utils.BUNDLE_KEY)
        val str = data.get("string")
        val integer = data.get("int")

        val info = "$str $integer"
        tv_info.text = info

        btn_send.setOnClickListener(sendClicked())

//        var value = intent.getStringExtra("input.key")
//        tv_info.text = value
    }
}
