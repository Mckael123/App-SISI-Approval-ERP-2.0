package com.example.forcaerp20.DashboardPage.pendingFragment

import android.app.DatePickerDialog
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.forcaerp20.R
import java.util.*


class SideFilterPendingFragment : Fragment() {
    var onDateSetListener: DatePickerDialog.OnDateSetListener? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var fieldStartDateFilter: AutoCompleteTextView = view.findViewById(R.id.StartDatePending)
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]
        fieldStartDateFilter.setOnClickListener{
            val datePickerDialog = DatePickerDialog(
                requireActivity(), android.R.style.
                Theme_Holo_Light_Dialog_MinWidth,

                onDateSetListener, year, month, day
            )
            datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            datePickerDialog.show()
        }
        onDateSetListener =
            DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
                var month = month
                month = month + 1
                val date = "$dayofMonth/$month/$year"
                fieldStartDateFilter.setText(date)
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