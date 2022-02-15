package com.example.forcaerp20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class HelpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_help, container, false)

        val feedbackbtn :TextView = view.findViewById(R.id.feedback)
        feedbackbtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_feedbackFragment)
        }

        val faqbtn :TextView = view.findViewById(R.id.faq)
        faqbtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_helpFragment_to_FAQFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}