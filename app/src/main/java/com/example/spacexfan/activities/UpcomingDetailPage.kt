package com.example.spacexfan.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.spacexfan.databinding.ActivityUpcomingDetailPageBinding

class UpcomingDetailPage : AppCompatActivity() {

    private lateinit var binding: ActivityUpcomingDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpcomingDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val date = intent.getStringExtra("date")
        val info = intent.getStringExtra("info")
        val fn = intent.getIntExtra("flight_number",0)

        binding.apply {

            upcomingDetailName.setText(name)
            upcomingDetailDate.setText("Date: "+date)
            upcomingDetailFN.setText("Flight Number: "+fn)
            if (info != null){
                upcomingDetailInfo.setText("Detail: "+info)
            }else{
                upcomingDetailInfo.setText("Detail: Details have not been shared yet! ")
            }
            if (image != "null"){
                Glide.with(applicationContext).load(image).into(upcomingDetailImage)
            }

        }
    }
}