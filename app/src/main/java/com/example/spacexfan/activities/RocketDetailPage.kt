package com.example.spacexfan.activities

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.example.spacexfan.R
import com.example.spacexfan.adapters.SlideAdapter
import com.example.spacexfan.databinding.ActivityRocketDetailPageBinding
import com.example.spacexfan.models.Rockets
import com.example.spacexfan.objects.AppObject
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.ref.Reference

class RocketDetailPage : AppCompatActivity() {

    private lateinit var binding:ActivityRocketDetailPageBinding
    private lateinit var reference: DatabaseReference

    var flagFav:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRocketDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        reference = database.getReference("Favorites")

        val images = intent.getStringArrayListExtra("images")
        val name = intent.getStringExtra("name")
        val ff = intent.getStringExtra("f_flight")
        val country = intent.getStringExtra("country")
        val success = intent.getIntExtra("success",0)
        val description = intent.getStringExtra("description")
        val height = intent.getDoubleExtra("height",0.0)
        val weight = intent.getDoubleExtra("weight", 0.0)

        val slideAdapter = SlideAdapter(images!!)
        binding.apply {

            rocketName.setText(name)
            rocketCountry.setText("Country: "+country)
            rocketSuccess.setText("Success: "+success+"%")
            rocketFF.setText("First Flight: "+ff)
            rocketDescription.setText("Description: "+description)
            rocketHeight.setText("Height: "+ height + " m")
            rocketWeight.setText("Weight: "+weight+" kg")

            viewPager.adapter = slideAdapter

            reference.child(AppObject.uid).child(name.toString()).get().addOnSuccessListener {
                if (it.value == "true"){

                    flagFav = true
                    btnDetailFav.setBackgroundResource(R.drawable.fav_full)

                }else{
                    flagFav = false
                }
            }

            btnDetailFav.setOnClickListener {
                controlFav()

            }
        }
    }

    fun controlFav(){

        var r_name = binding.rocketName.text.toString()

        if (flagFav == false){
            reference.child(AppObject.uid).child(r_name).setValue("true").addOnCompleteListener {

                if (it.isSuccessful){
                    binding.btnDetailFav.setBackgroundResource(R.drawable.fav_full)
                    flagFav = true
                }else{
                    Toast.makeText(applicationContext, "Data insertion failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            reference.child(AppObject.uid).child(r_name).removeValue().addOnCompleteListener {

                if (it.isSuccessful){
                    binding.btnDetailFav.setBackgroundResource(R.drawable.fav_empty)
                    flagFav = false
                }else{
                    Toast.makeText(applicationContext, "Data deletion failed!", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}