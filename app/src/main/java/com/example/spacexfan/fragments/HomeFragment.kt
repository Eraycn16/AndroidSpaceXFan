package com.example.spacexfan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.spacexfan.R
import com.example.spacexfan.adapters.SlideAdapter
import com.example.spacexfan.databinding.FragmentHomeBinding
import com.example.spacexfan.models.Company
import com.example.spacexfan.services.Service
import com.example.spacexfan.utils.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        val service = ApiClient.getClient().create(Service::class.java)
        var companyService = service.getCompanyInfo()


        binding.apply {
            companyService.enqueue(object : Callback<Company> {
                override fun onResponse(call: Call<Company>, response: Response<Company>) {
                    if (response.isSuccessful){
                        companyCEO.setText("CEO: "+response.body()!!.ceo)
                        companyName.setText("Welcome to "+response.body()!!.name)
                        companyCOO.setText("COO: "+ response.body()!!.coo)
                        companyEmp.setText("Employees: "+response.body()!!.employees.toString())
                        companySummary.setText("Summary: "+response.body()!!.summary)
                        companyFounder.setText("Founder: "+response.body()!!.founder)
                        companyAddress.setText("Address: "+response.body()!!.headquarters!!.address +","
                                + response.body()!!.headquarters!!.city + " / "+ response.body()!!.headquarters!!.state)
                    }
                }

                override fun onFailure(call: Call<Company>, t: Throwable) {
                    Toast.makeText(context, "Service Error!", Toast.LENGTH_SHORT).show()
                }

            })

            val listImg = imagesUrl()
            val adapter = SlideAdapter(listImg)
            viewPagerHome.adapter = adapter
        }


        return binding.root
    }

    fun imagesUrl(): ArrayList<String>{
        var listImage = ArrayList<String>()
        listImage.add("https://cdnuploads.aa.com.tr/uploads/Contents/2020/05/30/thumbs_b_c_a4a6996640e91d4ff86a71f5d9d9f84b.jpg?v=225920")
        listImage.add("https://farm3.staticflickr.com/2815/32761844973_4b55b27d3c_b.jpg")
        return listImage
    }

}