package com.example.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.application.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener {
            val nama = binding.etNamaReg.text.toString()
            val email = binding.etEmailReg.text.toString()
            val password = binding.etPasswordReg.text.toString()

            if (nama.isEmpty()){
                binding.etNamaReg.error = "Nama Tidak Boleh Kosong"
                binding.etNamaReg.requestFocus()
                return@setOnClickListener
            }
            if (email.isEmpty()){
                binding.etEmailReg.error = "Email Tidak Boleh Kosong"
                binding.etEmailReg.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmailReg.error = "Email Tidak Valid"
                binding.etEmailReg.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.etPasswordReg.error = "Password Tidak Boleh Kosong"
                binding.etPasswordReg.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 8){
                binding.etPasswordReg.error = "Password Minimal 8 Karakter"
                binding.etPasswordReg.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(nama,email,password)
        }
    }

    private fun RegisterFirebase(nama: String, email: String, password: String) {
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
                        val login = Intent(this, Login::class.java)
                        startActivity(login)
                    } else{
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}