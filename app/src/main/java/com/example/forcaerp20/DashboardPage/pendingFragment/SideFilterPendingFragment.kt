package com.example.forcaerp20.DashboardPage.pendingFragment

import android.app.DatePickerDialog
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.forcaerp20.R
import java.util.*


class SideFilterPendingFragment : Fragment() {
    var onStartDateSetListener: DatePickerDialog.OnDateSetListener? = null
    var onEndDateSetListener: DatePickerDialog.OnDateSetListener? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnFilterPending :Button = view.findViewById(R.id.filterSetPending)
        var fieldStartDateFilter: AutoCompleteTextView = view.findViewById(R.id.StartDatePending)
        var fieldEndDateFilter: AutoCompleteTextView = view.findViewById(R.id.EndDatePending)
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]


        fieldStartDateFilter.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                requireActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,

                onStartDateSetListener, year, month, day
            )
            datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            datePickerDialog.show()
        }
        onStartDateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
                var month = month
                month = month + 1
                val date = "$dayofMonth/$month/$year"
                fieldStartDateFilter.setText(date)
            }

        fieldEndDateFilter.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
            requireActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,

                onEndDateSetListener, year, month, day
        )
            datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            datePickerDialog.show() }

        onEndDateSetListener= DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
            var month = month
            month = month + 1
            val date = "$dayofMonth/$month/$year"
            fieldEndDateFilter.setText(date)}

        var FilterPendingSortGroup :RadioGroup = view.findViewById(R.id.RadioGroup_filterPending)
        FilterPendingSortGroup.setOnCheckedChangeListener { radioGroup, Radio_id ->
            if (Radio_id == R.id.radioButton_Asc){
                Toast.makeText(requireContext(), "A to Z" , Toast.LENGTH_SHORT).show()
            }
            else if (Radio_id == R.id.radioButton_Desc){
                Toast.makeText(requireContext(), "Z to A" , Toast.LENGTH_SHORT).show()
            }
        }


        btnFilterPending.setOnClickListener {
            val StartDate = fieldStartDateFilter.text.toString().trim()
            val EndtDate = fieldEndDateFilter.text.toString().trim()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_side_filter_pending, container, false)
    }


}