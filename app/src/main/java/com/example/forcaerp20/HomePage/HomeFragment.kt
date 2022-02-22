package com.example.forcaerp20.HomePage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import com.example.forcaerp20.DashboardPage.DashboardActivity
import com.example.forcaerp20.R
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class HomeFragment : Fragment() {

    var sliderView: SliderView? = null
    var images = intArrayOf(
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3
    )
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var listener: NavController.OnDestinationChangedListener
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var sliderView: SliderView = view.findViewById(R.id.image_slider)
        val sliderAdapter = SliderAdapter(images)
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.SLIDE)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.startAutoCycle()

        var buttonTodashboard: Button = view.findViewById(R.id.gotodashboard)
        var buttonReportTodashboard: Button = view.findViewById(R.id.reportToDashboard)
        buttonTodashboard.setOnClickListener {
            var intentodashboard = Intent(activity, DashboardActivity::class.java)
            startActivity(intentodashboard)
        }
        buttonReportTodashboard.setOnClickListener {
            var intentodashboard = Intent(activity, DashboardActivity::class.java)
            startActivity(intentodashboard)
        }


        var textMoveToNews: TextView = view.findViewById(R.id.moveToNewsFragment)
        textMoveToNews.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_homeFragment_to_newsFromHomeFragment)
        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }


}