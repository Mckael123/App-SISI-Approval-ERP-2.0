package com.example.forcaerp20.DashboardPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.forcaerp20.DashboardPage.fragments.ApprovFragment
import com.example.forcaerp20.DashboardPage.fragments.PendingFragment
import com.example.forcaerp20.R
import com.example.forcaerp20.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pendingFragment = PendingFragment()
        val approvFragment = ApprovFragment()

        makeCurrentFragment(pendingFragment)
        bottomNav = findViewById(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.pending -> makeCurrentFragment(pendingFragment)
                R.id.approv -> makeCurrentFragment(approvFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}