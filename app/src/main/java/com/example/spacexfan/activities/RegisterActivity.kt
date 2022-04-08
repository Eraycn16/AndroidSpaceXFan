package com.example.spacexfan.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.spacexfan.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnRegister.setOnClickListener {

            val email = binding.userMailRegister.text
            val password = binding.userPasswordRegister.text

            if (email.isNotEmpty()){
                if (password.isNotEmpty()){

                    auth.createUserWithEmailAndPassword(email.toString(),password.toString()).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(applicationContext, "Registration successfully created", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }

                }else{
                    binding.userPasswordRegister.error = "Password field cannot be left blank"
                }
            }else{
                binding.userMailRegister.error = "Mail field cannot be left blank"
            }
        }
    }
}