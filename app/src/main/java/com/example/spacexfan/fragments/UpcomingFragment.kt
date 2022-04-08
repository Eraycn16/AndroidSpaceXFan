package com.example.spacexfan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexfan.R
import com.example.spacexfan.adapters.UpcomingAdapter
import com.example.spacexfan.databinding.FragmentUpcomingBinding
import com.example.spacexfan.models.Upcoming
import com.example.spacexfan.services.Service
import com.example.spacexfan.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding:FragmentUpcomingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpcomingBinding.inflate(inflater,container,false)

        binding.recyclerUpcoming.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)

        val service = ApiClient.getClient().create(Service::class.java)
        var upcomingService = service.getUpcoming()
        var list: List<Upcoming.UpcomingItem>

        upcomingService.enqueue(object : Callback<Upcoming> {
            override fun onResponse(call: Call<Upcoming>, response: Response<Upcoming>) {

                if (response.isSuccessful){
                    list = response.body()!!
                    getData(list)

                }else{
                    Toast.makeText(binding.root.context, "Response Error!", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<Upcoming>, t: Throwable) {
                Toast.makeText(binding.root.context, "Service Error!", Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }

    private fun getData(upcomingList : List<Upcoming.UpcomingItem>){

        var adapter = UpcomingAdapter(upcomingList)
        binding.recyclerUpcoming.adapter = adapter
    }

}