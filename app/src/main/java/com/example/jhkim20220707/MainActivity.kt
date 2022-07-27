package com.example.jhkim20220707

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {

        val buttonEvent = findViewById<Button>(R.id.button_event)
        buttonEvent.setOnClickListener {

        }







    }
}