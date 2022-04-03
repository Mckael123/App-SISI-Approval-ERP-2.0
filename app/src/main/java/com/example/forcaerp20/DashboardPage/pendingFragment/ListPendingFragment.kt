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
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ListPendingFragment : Fragment() {

    private lateinit var recylerPending: RecyclerView
    private lateinit var listPendingArray: ArrayList<ListPending>
    private lateinit var tempArrayList : ArrayList<ListPending>
    private lateinit var pendingDrawerlayout :DrawerLayout


    lateinit var TypeDocument: Array<String>
    lateinit var NameDocument: Array<String>
    lateinit var NumberDocument: Array<Int>
    lateinit var PartnerDocument: Array<String>
    lateinit var NominalDocument: Array<String>
    lateinit var DateDocument: Array<String>
    lateinit var HistoryDocument: Array<String>
    lateinit var DescriptionDocument: Array<String>
    lateinit var StatusDocument: Array<String>
    lateinit var  adapter:ListPendingAdapter

    var onStartDateSetListener: DatePickerDialog.OnDateSetListener? = null
    var onEndDateSetListener: DatePickerDialog.OnDateSetListener? = null
    var asc_pending :Boolean? = null
    var desc_pending :Boolean? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pendingDrawerlayout = view.findViewById(R.id.drawer_layout_pending)
        pendingDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        var btnfilterPending :Button = view.findViewById(R.id.BtnFilterPending)

        btnfilterPending.setOnClickListener {
            pendingDrawerlayout.openDrawer(GravityCompat.END, true)
        }

        var fieldStartDateFilter: AutoCompleteTextView = view.findViewById(R.id.StartDatePending)
        var fieldEndDateFilter: AutoCompleteTextView = view.findViewById(R.id.EndDatePending)
        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]

        //select start date
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
        //select end date
        onEndDateSetListener= DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
            var month = month
            month = month + 1
            val date = "$dayofMonth/$month/$year"
            fieldEndDateFilter.setText(date)}

        var FilterPendingSortGroup : RadioGroup = view.findViewById(R.id.RadioGroup_filterPending)
        FilterPendingSortGroup.setOnCheckedChangeListener { radioGroup, Radio_id ->
            if (Radio_id == R.id.radioButton_Asc){
                 asc_pending= true
                desc_pending = false

            }
            else if (Radio_id == R.id.radioButton_Desc){
                desc_pending= true
                asc_pending= false

            }
        }


        //contoh data
        TypeDocument= arrayOf("AP Payment","AP Payment","AP Payment")
        NameDocument = arrayOf(
            "Daxa Leave 2100016: idaF -555 ",
            "Forca Leave 2100016: idaF -46 ",
            "Barca Leave 2100016: idaF -466"
        )
        NumberDocument = arrayOf(1234567,2100018,3958002)
        PartnerDocument= arrayOf("","", "")
        NominalDocument = arrayOf("","","")
        DateDocument = arrayOf("16-1-2022", "01-1-2021", "16-10-2021")
        HistoryDocument= arrayOf("2021-12-16 12:02 :Indri Annisa Ghaida ([Start)\n" +
                "2021-12-16 12:02 :Indri Annisa Ghaida\n" +
                "((DocPrepare)]\n" +
                "2021-12-16 12:02 :Donny Bustan Fauzi\n" +
                "(Approve_Leader))\n" +
                "2021-12-29 08:37:null ((Approve_Manager))\n" +
                "2022-01-13 11:20 :Indri Annisa Ghaida\n" +
                "((DocComplete))","2021-12-28 12:18 :ndri Annisa Ghaida ((Start))\n" +
                "2021-12-28 12:18 :Indri Annisa Ghaida\n" +
                "(DocPrepare))","24/01/2022 15.06 : Ariel Bintang Rafid ((Start))\n" +
                "24/01/2022 15.06 : Ariel Bintang Rafid\n" +
                "((DocPrepare))")
        DescriptionDocument = arrayOf("mas Don, mas Fib. Indri izin ke Puskesmas mas.\n" +
                "Mau cek batuk mas. batuk indri berdarah. mohon\n" +
                "izin ya mas, makasi ya mas", "mas Don, mas Fib. Saya izin pulang karena demam","mas Don saya izin untuk meminta approval document dari anak magang")
        StatusDocument= arrayOf("Pending","Pending","Pending")

        listPendingArray = arrayListOf()
        tempArrayList = arrayListOf()
        tempArrayList.addAll(listPendingArray)

        for (i in NameDocument.indices) {

            val PendingDocumentList = ListPending()
            PendingDocumentList.TypePendingDocument = TypeDocument[i]
            PendingDocumentList.NamePendingDocument = NameDocument[i]
            PendingDocumentList.NumberPendingDocument = NumberDocument[i]
            PendingDocumentList.BusinessPendingDocument = PartnerDocument[i]
            PendingDocumentList.NominalPendingDocument = NominalDocument[i]
            PendingDocumentList.DatePendingDocument = DateDocument[i]
            PendingDocumentList.HistoryPendingDocument = HistoryDocument[i]
            PendingDocumentList.DescriptionPendingDocument = DescriptionDocument[i]
            PendingDocumentList.StatusPendingDocument = StatusDocument[i]
            listPendingArray.add(PendingDocumentList)
        }


        recylerPending = view.findViewById(R.id.pending_list_RecyclerView)
        recylerPending.layoutManager = LinearLayoutManager(requireActivity())
        var adapter = ListPendingAdapter(listPendingArray)
        recylerPending.adapter = adapter

        adapter.setOnItemClickListener(object : ListPendingAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val listToDetailPending =
                    ListPendingFragmentDirections.actionListPendingFragmentToDetailPendingFragment(
                        documentType = listPendingArray[position].TypePendingDocument,
                        documentName = listPendingArray[position].NamePendingDocument,
                        documentNumber = listPendingArray[position].NumberPendingDocument,
                        businessPartner = listPendingArray[position].BusinessPendingDocument,
                        documentNominal = listPendingArray[position].NominalPendingDocument,
                        documentDate = listPendingArray[position].DatePendingDocument,
                        documentHistory = listPendingArray[position].HistoryPendingDocument,
                        documentDescription = listPendingArray[position].DescriptionPendingDocument,
                        documentStatus = listPendingArray[position].StatusPendingDocument
                    )
                Navigation.findNavController(view)
                    .navigate(listToDetailPending)
            }

        })


        var arrowBacktoPendingDash = view.findViewById<Button>(R.id.back_to_dashboardPending)
        arrowBacktoPendingDash.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_listPendingFragment_to_pendingFragment)
        }

        var btnFilter :Button = view.findViewById(R.id.filterSetPending)

        btnFilter.setOnClickListener {
            val StartDate = fieldStartDateFilter.text.toString().trim()
            val EndDate = fieldEndDateFilter.text.toString().trim()
//            if((!StartDate.equals("")||!EndDate.equals("")||!StartDate.equals(null)||!EndDate.equals(null))){
////                try {
////                    var dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
////                    val strDate = dateFormatter.parse(StartDate)
////                    val endDate = dateFormatter.parse(EndDate)
////                   filterDateRange(strDate,endDate)
////                }catch (e: ParseException){
////                    e.printStackTrace()
////                }
//                Toast.makeText(requireContext(), "$StartDate & $EndDate" , Toast.LENGTH_SHORT).show()
//            }

            //milih tanggal sama  mencet tombol AZ
            if(StartDate!="dd/mm/yyyy" && EndDate!="dd/mm/yyyy"&& asc_pending== true){
                Toast.makeText(requireContext(), "$StartDate & $EndDate with AZ" , Toast.LENGTH_SHORT).show()
                Collections.sort(listPendingArray,ListPending.sortByNameAZ)
                adapter.notifyDataSetChanged()
            }
            else if(StartDate!="dd/mm/yyyy" && EndDate!="dd/mm/yyyy"&& desc_pending== true){
                Collections.sort(listPendingArray,ListPending.sortByNameZA)
                Toast.makeText(requireContext(), "$StartDate & $EndDate with ZA" , Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
            //cuma milih tanggal
            else if (StartDate!="dd/mm/yyyy" && EndDate!="dd/mm/yyyy"){
                Toast.makeText(requireContext(), "$StartDate & $EndDate" , Toast.LENGTH_SHORT).show()
            }
            //cuma mencet tombol AZ
            else if (asc_pending== true){
                Collections.sort(listPendingArray,ListPending.sortByNameAZ)
                Toast.makeText(requireContext(), "A to Z" , Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
            //cuma mencet tombol ZA
            else if (desc_pending== true){
                Collections.sort(listPendingArray,ListPending.sortByNameZA)
                Toast.makeText(requireContext(), "Z to A" , Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }
            pendingDrawerlayout.closeDrawers()
        }

        var btnClearFilter :Button = view.findViewById(R.id.filterClearPending)
            btnClearFilter.setOnClickListener {
                FilterPendingSortGroup.clearCheck()
                fieldStartDateFilter.setText("dd/mm/yyyy")
                fieldEndDateFilter.setText("dd/mm/yyyy")
                asc_pending = false
                desc_pending = false
//                recylerPending.layoutManager
//                recylerPending.layoutManager = LinearLayoutManager(requireActivity())
//                adapter = ListPendingAdapter(listPendingArray)
//                recylerPending.adapter = adapter

            }
    }

    //filter class
    fun filterDateRange(charText: Date, charText1: Date) {
        listPendingArray.clear()
        if (charText.equals("") || charText.equals(null)) {
            listPendingArray.addAll(tempArrayList)
        } else {
            for (wp in tempArrayList) {
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                try {
                    val strDate: Date = sdf.parse(wp.DatePendingDocument)
                    if (charText1.after(strDate) && charText.before(strDate)) {
                        listPendingArray.add(wp)
                    }
                } catch (e: ParseException) {
                    e.printStackTrace()
                }
            }
        }
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_pending, container, false)
    }


}