package com.example.marsrover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.marsrover.databinding.ActivityMainBinding
import com.example.marsrover.view.main.MainFragment
import com.example.marsrover.view.favorite.FavoriteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var mBind: ActivityMainBinding? = null
    private val binding get() = mBind!!
    lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        bottomNavigationView = findViewById(R.id.bottomNavigation)


        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, MainFragment())
                    .commit()
                R.id.favoritePhoto -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, FavoriteFragment())
                    .addToBackStack(MainFragment().toString())
                    .commit()
                else -> {
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}