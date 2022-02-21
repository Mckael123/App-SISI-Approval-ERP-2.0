package com.example.forcaerp20.ProfilePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.forcaerp20.R


class EditProfileFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val SettingtDialog = AlertDialog.Builder(requireActivity())

        //edit foto
        var editProfile: Button= view.findViewById(R.id.cameraProfile)

        editProfile.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.profile_popup, null)
            val builder = SettingtDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val profileTakebtn = view.findViewById<TextView>(R.id.profileTake)
            val profileNewbtn = view.findViewById<TextView>(R.id.newProfile)
            val profileDeletebtn = view.findViewById<TextView>(R.id.deleteProfile)

            profileTakebtn.setOnClickListener {
                dialog.dismiss()
            }
            profileNewbtn.setOnClickListener {
                dialog.dismiss()
            }
            profileDeletebtn.setOnClickListener {
                dialog.dismiss()
            }}

        //edit header
        var editHeader: Button= view.findViewById(R.id.cameraHeader)
        editHeader.setOnClickListener {
            val view = View.inflate(requireActivity(), R.layout.header_popup, null)
            val builder = SettingtDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val headerTakebtn = view.findViewById<TextView>(R.id.takeapicture)
            val headerNewbtn = view.findViewById<TextView>(R.id.profileheader)
            val headerDeletebtn = view.findViewById<TextView>(R.id.deleteProfileHeader)

            headerTakebtn.setOnClickListener {
                dialog.dismiss()
            }
            headerNewbtn.setOnClickListener {
                dialog.dismiss()
            }
            headerDeletebtn.setOnClickListener {
                dialog.dismiss()
            }

        }

        //confrim or cancel

        var ConfirmEditProfile: Button = view.findViewById(R.id.confirmEditProfile)
        var CancelEditProfile: Button = view.findViewById(R.id.cancelEditProfile)

        ConfirmEditProfile.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.NavigateToProfile)
        }
        CancelEditProfile.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.NavigateToProfile)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false)

    }

}