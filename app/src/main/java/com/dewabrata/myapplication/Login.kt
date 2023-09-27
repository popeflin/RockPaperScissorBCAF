package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
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

            if(validation(txtUsername.text.toString(),txtPassword.text.toString())){
               Toast.makeText(this,"Login Berhasil",Toast.LENGTH_SHORT).show()
            }else{

                Toast.makeText(this,"Login Gagal",Toast.LENGTH_SHORT).show()
            }

        })


    }


    fun validation(username:String,password:String) : Boolean{
        val passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}\$".toRegex()

        if (username.isEmpty()){
            txtUsername.error = "Username tidak boleh kosong"
            return false
        }

        if(!password.matches(passwordPattern)){
            txtPassword.error = "Password harus mengandung huruf besar, angka, dan simbol"
            return false
        }


        return true

    }
}