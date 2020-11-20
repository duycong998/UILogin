package com.example.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mFragment = FragmentA()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.container, mFragment).commit()
    }
}