package com.anand.multiplefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.firstContainer, FirstFragment()).commit()

        supportFragmentManager.beginTransaction().replace(R.id.secondContainer, SecondFragment()).commit()

    }
}
