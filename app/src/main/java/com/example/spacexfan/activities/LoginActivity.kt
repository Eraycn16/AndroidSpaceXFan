package com.example.spacexfan.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.spacexfan.MainActivity
import com.example.spacexfan.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Firebase
        auth = Firebase.auth

        binding.btnGoRegister.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val mail = binding.userMail.text
            val password = binding.userPassword.text

            if (mail.isNotEmpty()){
                if (password.isNotEmpty()){

                    auth.signInWithEmailAndPassword(mail.toString(),password.toString()).addOnCompleteListener {

                        if (it.isSuccessful){
                            val i = Intent(this,MainActivity::class.java)
                            startActivity(i)
                            finish()
                        }else{
                            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    binding.userPassword.error = "Password field cannot be left blank"
                }
            }else{
                binding.userMail.error = "Mail field cannot be left blank"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null){
            val intent2 = Intent(this,MainActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }
}