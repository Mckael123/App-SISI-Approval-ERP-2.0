package com.example.forcaerp20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class EditProfileFragment : Fragment() {
    private lateinit var cameraHeader_btn: Button
    private lateinit var cameraProfile_btn: Button
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cameraProfileDialog = AlertDialog.Builder(requireActivity())
        cameraProfile_btn = requireActivity().findViewById(R.id.cameraProfile)

        val cameraHeaderDialog = AlertDialog.Builder(requireActivity())
        cameraHeader_btn = requireActivity().findViewById(R.id.cameraHeader)

        cameraProfile_btn.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.profile_popup, null)
            val builder = cameraProfileDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val confirmbtn4 = view.findViewById<Button>(R.id.profileTake)
            confirmbtn4.setOnClickListener {
                dialog.dismiss()
            }
            val confirmbtn5 = view.findViewById<Button>(R.id.newProfile)
            confirmbtn5.setOnClickListener {
                dialog.dismiss()
            }
            val confirmbtn6 = view.findViewById<Button>(R.id.deleteProfile)
            confirmbtn6.setOnClickListener {
                dialog.dismiss()
            }
        }

        cameraHeader_btn.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.header_popup, null)
            val builder = cameraHeaderDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(true)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val confirmbtn1 = view.findViewById<Button>(R.id.takeapicture)
            confirmbtn1.setOnClickListener {
                dialog.dismiss()
            }
            val confirmbtn2 = view.findViewById<Button>(R.id.profileheader)
            confirmbtn2.setOnClickListener {
                dialog.dismiss()
            }
            val confirmbtn3 = view.findViewById<Button>(R.id.deleteProfileHeader)
            confirmbtn3.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}