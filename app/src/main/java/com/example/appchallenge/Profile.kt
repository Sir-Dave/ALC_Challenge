package com.example.appchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_about.*
import android.widget.LinearLayout
import androidx.fragment.app.FragmentActivity


class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val image: ImageView = findViewById(R.id.my_photo)
        image.setOnClickListener{
            startActivity(Intent(this,Profile_Photo::class.java))
        }


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return true
    }
}
