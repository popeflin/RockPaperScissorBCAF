package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dewabrata.myapplication.model.DataBerita

class BeritaDetail : AppCompatActivity() {

    lateinit var berita : DataBerita
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_detail)
        berita = intent.getParcelableExtra("berita")!!

        Glide.with(this).load(berita.gambarBerita).into(findViewById(R.id.gambarBerita))
        findViewById<ImageView>(R.id.gambarUser).setImageResource(berita.gambarUser)
        findViewById<TextView>(R.id.txtJudul).text = berita.judulBerita
        findViewById<TextView>(R.id.txtBerita).text = berita.isiBerita


    }
}