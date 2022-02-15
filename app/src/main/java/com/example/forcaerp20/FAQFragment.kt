package com.example.forcaerp20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class FAQFragment : Fragment() {

    val versionList = ArrayList<Versions>()
    lateinit var recyclerView: RecyclerView

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
        return inflater.inflate(R.layout.fragment_f_a_q, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val versionAdapter = VersionAdapter(versionList)
        recyclerView = requireActivity().findViewById(R.id.recyclerView)
        recyclerView.adapter = versionAdapter
        recyclerView.setHasFixedSize(true)
    }

    private fun initData() {
        versionList.add(
            Versions(
            codeName = "What is Forca ERP?",
            description = "FORCA Suite (ERP, CRM, and HRIS) is here as the right solution for your company.\n" +
                    "\n" +
                    "We understand that currently all business people need to innovate and optimize the use of information technology (IT) in order to compete in the midst of a pandemic and industrial competition.\n" +
                    "\n" +
                    "Meanwhile, the rapid development of information technology (IT) is an opportunity for business people to take advantage of IT technology as an enabler or driver to increase company competitiveness."
            )
        )
        versionList.add(
            Versions(
                codeName = "How to approve document?",
                description = "After logging in, go to the dashboard menu to check whether the document wants to be accepted or rejected to proceed to the next menu."
            )
        )
        versionList.add(
            Versions(
                codeName = "How to edit or customize your account?",
                description = "To edit the account information section, users can enter the profile page on the sidebar of the home page, where users can find out information from the account and edit photos and emails."
            )
        )
    }
}