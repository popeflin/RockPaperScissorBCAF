package com.dewabrata.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        findViewById<TextView>(R.id.txtHeader).text = "Selamat Datang ${intent.getStringExtra("username")}"


        findViewById<CardView>(R.id.cardSimulasi).setOnClickListener(View.OnClickListener {
            intent = Intent(this, SimulasiCicilan::class.java)
            startActivity(intent)
        })
    }
}