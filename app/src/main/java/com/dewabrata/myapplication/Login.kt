package com.dewabrata.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Login : AppCompatActivity() {

    lateinit var btnLogin:Button
    lateinit var txtUsername : EditText
    lateinit var  txtPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin = findViewById(R.id.btnLogin)
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)

        btnLogin.setOnClickListener(View.OnClickListener {

            if(validation()){
               Toast.makeText(this,"Login Berhasil",Toast.LENGTH_SHORT).show()

               intent =  Intent(this, MainMenu::class.java)
               intent.putExtra("username",txtUsername.text.toString())
               startActivity(intent)

            }else{

                Toast.makeText(this,"Login Gagal",Toast.LENGTH_SHORT).show()
            }

        })

        findViewById<TextView>(R.id.txtLostPassword).setOnClickListener(View.OnClickListener {

            intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:08123456789"))
            startActivity(intent)

        })


    }


    fun validation() : Boolean{
        val passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}\$".toRegex()

        if (txtUsername.text.isBlank()){
            txtUsername.error = "Username tidak boleh kosong"
            return false
        }

        if(!txtPassword.text.matches(passwordPattern)){
            txtPassword.error = "Password harus mengandung huruf besar, angka, dan simbol"
            return false
        }


        return true

    }
}