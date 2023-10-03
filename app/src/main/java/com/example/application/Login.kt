package com.example.application

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.application.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.etRegister.setOnClickListener {
            val Reg = Intent(this, Register::class.java)
            startActivity(Reg)
        }

        binding.btnMasuk.setOnClickListener {
            val email = binding.etEmailLog.text.toString()
            val password = binding.etPasswordLog.text.toString()

            if (email.isEmpty()){
                binding.etEmailLog.error = "Email Tidak Boleh Kosong"
                binding.etEmailLog.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etEmailLog.error = "Email Tidak Valid"
                binding.etEmailLog.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                binding.etPasswordLog.error = "Password Tidak Boleh Kosong"
                binding.etPasswordLog.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val main = Intent(this, MainActivity::class.java)
                    startActivity(main  )
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}