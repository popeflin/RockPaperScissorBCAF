package com.dewabrata.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {

    lateinit var btnLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btnLogin = findViewById(R.id.btnLogin)


    }


    fun validation(username:String,password:String) : Boolean{
        val passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*])[A-Za-z0-9!@#\$%^&*]{8,}\$".toRegex()

        if(password.matches(passwordPattern)){
            //if true
        }

        return false

    }
}