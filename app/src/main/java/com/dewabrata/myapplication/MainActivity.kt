package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var txtHasil: TextView
    lateinit var  imgBatu : ImageView
    lateinit var  imgGunting : ImageView
    lateinit var  imgKertas : ImageView
    lateinit var  imgCPU : ImageView


    enum class  Pilihan {
        BATU, GUNTING,KERTAS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtHasil = findViewById<TextView>(R.id.txtHasil);
        txtHasil.text="Pemenangnya adalah"

        imgBatu = findViewById(R.id.imgBatu)
        imgGunting = findViewById(R.id.imgGunting)
        imgKertas = findViewById(R.id.imgKertas)
        imgCPU = findViewById(R.id.imgCPU)


        imgBatu.setOnClickListener( OnClickListener {
            Toast.makeText(this, "Batu", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.BATU)

        })

        imgKertas.setOnClickListener(OnClickListener {
            Toast.makeText(this, "Kertas", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.KERTAS)
        })

        imgGunting.setOnClickListener(OnClickListener {
            Toast.makeText(this, "Gunting", Toast.LENGTH_SHORT).show()
            rulesOfGames(Pilihan.GUNTING)
        } )


    }

    fun rulesOfGames (pilihanUser : Pilihan){
        val pilihanKomputer = Pilihan.values()[Random.nextInt(Pilihan.values().size)]

        when (pilihanKomputer){
            Pilihan.BATU -> imgCPU.setImageResource(R.drawable.batu)
            Pilihan.KERTAS -> imgCPU.setImageResource(R.drawable.kertas)
            Pilihan.GUNTING -> imgCPU.setImageResource(R.drawable.gunting)
        }


        when{
            pilihanUser == pilihanKomputer -> txtHasil.text = "SERI"

            (pilihanUser== Pilihan.BATU && pilihanKomputer == Pilihan.GUNTING) ||
            (pilihanUser== Pilihan.KERTAS && pilihanKomputer == Pilihan.BATU)  ||
            (pilihanUser== Pilihan.GUNTING && pilihanKomputer == Pilihan.KERTAS) -> txtHasil.text = "MENANG"
            else -> txtHasil.text = "KALAH"
        }


    }

    fun pindahHalaman(view: View) {
        Toast.makeText(this, "Pindah Halaman", Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume Jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
       // Toast.makeText(this, "OnPause Jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop Jalan", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(this, "Selametin dulu", Toast.LENGTH_SHORT).show()
    }
}