package com.example.spacexfan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.spacexfan.activities.LoginActivity
import com.example.spacexfan.databinding.ActivityMainBinding
import com.example.spacexfan.fragments.FavoritesFragment
import com.example.spacexfan.fragments.HomeFragment
import com.example.spacexfan.fragments.RocketsFragment
import com.example.spacexfan.fragments.UpcomingFragment
import com.example.spacexfan.objects.AppObject
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupNav()
        setContentView(binding.root)

        auth = Firebase.auth
        AppObject.uid = auth.currentUser!!.uid

        val homeFragment = HomeFragment()
        changeFragment(homeFragment)

    }


    fun setupNav(){

        actionBarToggle = ActionBarDrawerToggle(this,binding.drawerMain,binding.actBar.actionBar,0,0)
        binding.drawerMain.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()

        binding.navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.home ->{
                    val homeFragment = HomeFragment()
                    changeFragment(homeFragment)
                    binding.drawerMain.close()
                    true
                }
                R.id.rockets->{
                    val rocketFragment = RocketsFragment()
                    changeFragment(rocketFragment)
                    binding.drawerMain.close()
                    true
                }
                R.id.upcoming ->{
                    val upcomingFragment = UpcomingFragment()
                    changeFragment(upcomingFragment)
                    binding.drawerMain.close()
                    true
                }
                R.id.favorites ->{
                    val favoritesFragment = FavoritesFragment()
                    changeFragment(favoritesFragment)
                    binding.drawerMain.close()
                    true
                }
                R.id.exit->{
                    auth.signOut()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else ->{
                    false
                }
            }
        }
    }

    fun changeFragment(fragment: Fragment){
        val tra = supportFragmentManager.beginTransaction()
        tra.replace(binding.frame.id,fragment)
        tra.commit()
    }
}