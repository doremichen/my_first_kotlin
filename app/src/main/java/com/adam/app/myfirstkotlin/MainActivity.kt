package com.adam.app.myfirstkotlin

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var flag1 = false

    private fun getAction1Clicked() = View.OnClickListener {

        when (flag1) {
            true -> {
                tv_01.text = "This is chaged by action1 false"
                flag1 = false
            }
            false -> {
                tv_01.text = "This is chaged by action1 true"
                flag1 = true
            }
        }

    }

    private fun getStartActCliecked() = View.OnClickListener {
        var intent = Intent(this, OtherActivity1::class.java)
//        intent.putExtra("input.key", et_input.text.toString())

        val data = Bundle()
        data.putString("string", et_input.text.toString())
        data.putInt("int", 13579)
        intent.putExtra(Utils.BUNDLE_KEY, data)
//        startActivity(intent)
        startActivityForResult(intent, Utils.REQEUST_CODE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_01.text = "Wow....Magic!!"

        // Set click listener
        btn_action1.setOnClickListener(getAction1Clicked())
        btn_start_act.setOnClickListener(getStartActCliecked())

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.option1-> {
                Toast.makeText(this, "this is option1", Toast.LENGTH_SHORT).show()
                this.finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Utils.REQEUST_CODE) {
            if (resultCode == Utils.RESLUT_CODE) {
                val getData = data?.getBundleExtra(Utils.BUNDLE_KEY)
                val retStr = getData?.get(Utils.RADIO_KEY).toString()
                // Show
                tv_01.text = "Return data:   $retStr"
            }
        }
    }

    fun onShowDlg(v:View) {
        Utils.showDialog(this, "Test", "This is test alett dialog")
    }

    fun onSowCustToast(v : View) {
        Utils.showCustToast(this, "I am cust toast")
    }

    fun onShowSnack(v : View) {
        main_layout.setBackgroundColor(Color.GREEN)

        Utils.showSnack(main_layout, "This is snack bar")
    }
}
