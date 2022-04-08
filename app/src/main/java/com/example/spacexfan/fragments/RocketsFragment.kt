package com.example.spacexfan.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexfan.R
import com.example.spacexfan.adapters.RocketsAdapter
import com.example.spacexfan.databinding.FragmentRocketsBinding
import com.example.spacexfan.models.Rockets
import com.example.spacexfan.services.Service
import com.example.spacexfan.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RocketsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var binding: FragmentRocketsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRocketsBinding.inflate(inflater,container,false)
        binding.recyclerRockets.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)


        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val service = ApiClient.getClient().create(Service::class.java)
        var rocketsService = service.getRockets()

        var rocketList:ArrayList<Rockets.RocketsItem>

        rocketsService.enqueue(object : Callback<Rockets> {
            override fun onResponse(call: Call<Rockets>, response: Response<Rockets>) {

                if (response.isSuccessful){
                    rocketList = response.body()!!
                    getData(rocketList)
                }
            }

            override fun onFailure(call: Call<Rockets>, t: Throwable) {
                Log.d("TAG", "onFailure: "+t.message.toString())
            }

        })
    }

    fun getData(rocketList:ArrayList<Rockets.RocketsItem>){

        val adapter = RocketsAdapter(rocketList)
        binding.recyclerRockets.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}