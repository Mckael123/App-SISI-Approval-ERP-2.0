package com.example.forcaerp20.DashboardPage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.forcaerp20.DashboardPage.approveFragment.ApprovFragment
import com.example.forcaerp20.DashboardPage.pendingFragment.ListPendingFragment
import com.example.forcaerp20.HomePage.HomeActivity
import com.example.forcaerp20.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    private lateinit var appbarConfig: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()

        val pendingFragment = ListPendingFragment()
        val approvFragment = ApprovFragment()
        var btnToHome: Button = findViewById(R.id.back_to_home)
        val navController = findNavController(R.id.fragmentContainerViewDashboard)

//        makeCurrentFragment(pendingFragment)
        bottomNav = findViewById(R.id.bottom_navigation)

//        appbarConfig = AppBarConfiguration(setOf(R.id.pendingFragment,R.id.approvFragment))
//        setupActionBarWithNavController(navController,appbarConfig)
        bottomNav.setupWithNavController(navController)

//        bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.pending -> makeCurrentFragment(pendingFragment)
//                R.id.approv -> makeCurrentFragment(approvFragment)
//            }
//            true
//        }

        btnToHome.setOnClickListener {
            var intentoHome = Intent(this, HomeActivity::class.java)
            startActivity(intentoHome)
        }

    }
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_homes)
//        return navController.navigateUp(appbarConfig) || super.onSupportNavigateUp()
//
//    }


//    private fun makeCurrentFragment(fragment: Fragment) =
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragmentContainerViewDashboard, fragment)
//            commit()
//        }
}