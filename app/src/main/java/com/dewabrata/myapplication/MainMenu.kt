package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        findViewById<TextView>(R.id.txtHeader).text = "Selamat Datang ${intent.getStringExtra("username")}"
    }
}