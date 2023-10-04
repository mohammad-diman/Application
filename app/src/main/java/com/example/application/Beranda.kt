package com.example.application

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.application.databinding.FragmentBerandaBinding


class Beranda : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        //mendapatkan referensi ke buttton
        val buttonToActivitya = view.findViewById<Button>(R.id.btn_ippkh)
        val buttonToActivityb = view.findViewById<Button>(R.id.btn_pem_barang)
        val buttonToActivityc = view.findViewById<Button>(R.id.btn_map)

        // Lakukan apa yang Anda inginkan dengan someView di sini
        buttonToActivitya.setOnClickListener {
            val a = Intent(activity, IPPKH::class.java)
            // Jika Anda ingin mengirim data tambahan
//           intent.putExtra("key", value)
            startActivity(a)
        }

        buttonToActivityb.setOnClickListener {
            val b = Intent(activity, Pem_Barang::class.java)
            // Jika Anda ingin mengirim data tambahan
//           intent.putExtra("key", value)
            startActivity(b)
        }

        buttonToActivityc.setOnClickListener {
            val c = Intent(activity, MAP::class.java)
            // Jika Anda ingin mengirim data tambahan
//           intent.putExtra("key", value)
            startActivity(c)
        }

        return view
    }





}