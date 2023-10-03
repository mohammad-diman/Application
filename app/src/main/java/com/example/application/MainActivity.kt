package com.example.application

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.application.databinding.ActivityMainBinding
import com.example.application.databinding.FragmentBerandaBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(0, 0)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Beranda())
//        setContentView(R.layout.activity_main)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.btn_beranda -> replaceFragment(Beranda())
                R.id.btn_notifikasi -> replaceFragment(Notifikasi())
                R.id.btn_profil -> replaceFragment(Profil())

                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container,fragment)
        fragmentTransaction.commit()
    }


}
