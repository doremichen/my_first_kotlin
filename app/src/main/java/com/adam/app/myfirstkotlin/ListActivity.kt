package com.adam.app.myfirstkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_layout.*

class ListActivity : AppCompatActivity() {

   private val items: Array<String> = arrayOf("Demo UI", "Demo thread", "Exit")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        Utils.showToast(this, "List view is created")
        // build array adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        // build list
        list_view.adapter = adapter

        list_view.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Log.i("Demo", "List item $selectedItem is clicked")
            Utils.showToast(this, "List item: $selectedItem is clicked")
            var temp = items[0]
            Log.i("Demo", "$selectedItem $temp ")
            when (selectedItem) {
                items[0] -> {
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                items[1] -> {
                    var intent = Intent(this, ThreadActivity::class.java)
                    startActivity(intent)
                }
                items[items.size - 1] -> {
                    // exit
                    finish()
                }

            }

        }

    }
}

