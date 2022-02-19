package com.example.forcaerp20.HelpPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.forcaerp20.R

class FeedbackFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val SettingtDialog = AlertDialog.Builder(requireActivity())

        //OK
        var sendBtn: Button = view.findViewById(R.id.sendBtn)

        sendBtn.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.feedback_popup, null)
            val builder = SettingtDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val OKbtn = view.findViewById<TextView>(R.id.OK)

            OKbtn.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}