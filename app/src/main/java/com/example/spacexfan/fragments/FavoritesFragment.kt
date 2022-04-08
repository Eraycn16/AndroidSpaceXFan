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
import com.example.spacexfan.databinding.FragmentFavoritesBinding
import com.example.spacexfan.models.Rockets
import com.example.spacexfan.objects.AppObject
import com.example.spacexfan.services.Service
import com.example.spacexfan.utils.ApiClient
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoritesBinding.inflate(inflater,container,false)
        binding.reyclerFav.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        reference = Firebase.database.getReference("Favorites")
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val service = ApiClient.getClient().create(Service::class.java)
        var rocketsService = service.getRockets()

        var rocketList:ArrayList<Rockets.RocketsItem>
        var favRocketList = Rockets()

        rocketsService.enqueue(object : Callback<Rockets> {
            override fun onResponse(call: Call<Rockets>, response: Response<Rockets>) {

                if (response.isSuccessful){

                    rocketList = response.body()!!
                    for(myitem in rocketList){
                        reference.child(AppObject.uid).child(myitem.name.toString()).get().addOnSuccessListener {

                            if (it.value == "true"){
                                favRocketList.add(myitem)
                                getData(favRocketList)
                            }

                        }
                    }

                }
            }

            override fun onFailure(call: Call<Rockets>, t: Throwable) {
                Log.d("TAG", "onFailure: "+t.message.toString())
            }

        })
    }

    fun getData(favList: ArrayList<Rockets.RocketsItem>){

        val adapter = RocketsAdapter(favList)
        binding.reyclerFav.adapter = adapter
        adapter.notifyDataSetChanged()

    }

}