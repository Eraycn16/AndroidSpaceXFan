package com.example.spacexfan.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spacexfan.activities.UpcomingDetailPage
import com.example.spacexfan.databinding.UpcomingItemBinding
import com.example.spacexfan.models.Upcoming

class UpcomingAdapter(val listUpcoming: List<Upcoming.UpcomingItem>) : RecyclerView.Adapter<UpcomingAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: UpcomingItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = UpcomingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listUpcoming.get(position)

        holder.binding.apply {

            upcomingName.setText(item.name)
            upcomingDate.setText(item.dateLocal)

            val imageUrl = item.links!!.patch!!.small
            if (imageUrl != null){
                Glide.with(root.context).load(imageUrl).into(upcomingImage)
            }

            cardUpcoming.setOnClickListener {
                val intent = Intent(root.context, UpcomingDetailPage::class.java)
                intent.putExtra("name",item.name)
                intent.putExtra("image",item.links.patch!!.large.toString())
                intent.putExtra("date",item.dateLocal)
                intent.putExtra("info",item.details)
                intent.putExtra("flight_number",item.flightNumber)
                root.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return listUpcoming.size
    }
}