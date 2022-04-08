package com.example.spacexfan.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spacexfan.R
import com.example.spacexfan.activities.RocketDetailPage
import com.example.spacexfan.databinding.RocketItemBinding
import com.example.spacexfan.models.Rockets
import com.example.spacexfan.objects.AppObject
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class RocketsAdapter(val rocketList: ArrayList<Rockets.RocketsItem>) : RecyclerView.Adapter<RocketsAdapter.MyViewHolder>() {

    class MyViewHolder(val binding:RocketItemBinding): RecyclerView.ViewHolder(binding.root){}

    private lateinit var reference: DatabaseReference

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         val binding = RocketItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        reference = Firebase.database.getReference("Favorites")

        val item = rocketList.get(position)
        holder.binding.apply {
            nameRocket.setText(item.name)

            reference.child(AppObject.uid).child(item.name.toString()).get().addOnSuccessListener {

                if (it.value == "true"){
                    btnRocketFav.setBackgroundResource(R.drawable.fav_full)
                }else{
                    btnRocketFav.setBackgroundResource(R.drawable.fav_empty)
                }
            }

            val image = item.flickrİmages!!.get(0)
            if (image != null){
                Glide.with(root.context).load(image).into(imageRocket)
            }

            cardRocket.setOnClickListener {
                val imageList = item.flickrİmages as ArrayList<String>
                val intent = Intent(root.context, RocketDetailPage::class.java)

                intent.putStringArrayListExtra("images",imageList)
                intent.putExtra("name",item.name)
                intent.putExtra("f_flight",item.firstFlight)
                intent.putExtra("country",item.country)
                intent.putExtra("success",item.successRatePct)
                intent.putExtra("description",item.description)
                intent.putExtra("height",item.height!!.meters)
                intent.putExtra("weight",item.mass!!.kg)

                root.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return rocketList.size
    }
}


