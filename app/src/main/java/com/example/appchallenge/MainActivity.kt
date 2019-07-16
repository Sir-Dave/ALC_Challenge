package com.example.appchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.btn_1)
        btn1.setOnClickListener{
            startActivity(Intent(this, About::class.java))

        val btn2: Button = findViewById(R.id.btn_2)
            btn2.setOnClickListener{
                startActivity(Intent(this, Profile::class.java))
            }
        }


    }
}