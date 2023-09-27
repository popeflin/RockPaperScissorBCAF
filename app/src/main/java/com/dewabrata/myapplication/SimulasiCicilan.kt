package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.slider.Slider.OnChangeListener

class SimulasiCicilan : AppCompatActivity() {

    lateinit var jmlUang : SeekBar
    lateinit var txtPinjaman : TextView
    lateinit var interestArray : Array<Double>

    lateinit var  lstInterest : Spinner
    lateinit var  grpTenor : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simulasi_cicilan)

        jmlUang = findViewById(R.id.jmlUang)
        txtPinjaman = findViewById(R.id.txtPinjaman)
        lstInterest = findViewById(R.id.lstBunga)

        grpTenor = findViewById(R.id.grpTenor)

        setupSpinnerInterest()


        jmlUang.setOnSeekBarChangeListener( object :SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val jumlahUang = (p1 +1) * 1000000
                txtPinjaman.text = "Rp $jumlahUang"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    fun setupSpinnerInterest () {
        interestArray  = arrayOf(0.027 , 0.003)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, interestArray)
        lstInterest.adapter = adapter
    }


    fun hitungCicilan (view : View){
        val jumlahUang = (jmlUang.progress + 1 ) * 1000000
        val tenor = grpTenor.checkedRadioButtonId
        var nilaiTenor = 0

        when(tenor) {
            R.id.radioButton -> nilaiTenor = 3
            R.id.radioButton2 -> nilaiTenor = 6
            R.id.radioButton3 -> nilaiTenor = 12
        }

        val selectedBunga = interestArray[lstInterest.selectedItemPosition]

        val r = selectedBunga
        var cicilan = jumlahUang * r / (1 - Math.pow((1+r),-tenor.toDouble()))
        Toast.makeText(this,"Cicilanya adalah $cicilan",Toast.LENGTH_LONG).show()
    }
}