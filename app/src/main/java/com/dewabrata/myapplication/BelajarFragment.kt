package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.dewabrata.myapplication.fragment.FragmentA
import com.dewabrata.myapplication.fragment.FragmentB

class BelajarFragment : AppCompatActivity() {

    var isFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_belajar_fragment)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_fragment, FragmentA.newInstance("",""))
            .commit()

        findViewById<Button>(R.id.btnGanti).setOnClickListener(View.OnClickListener {
            if(isFragmentA) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, FragmentB.newInstance("", ""))
                    .commit()
                isFragmentA = false
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, FragmentA.newInstance("", ""))
                    .commit()
                isFragmentA = true
            }

        })

    }
}