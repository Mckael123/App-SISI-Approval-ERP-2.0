package com.example.forcaerp20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forcaerp20.databinding.ActivityDashboardBinding
import com.example.forcaerp20.databinding.ActivityHomeBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}