package com.example.forcaerp20.DashboardPage.approveFragment

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.DashboardPage.approveFragment.ListApproved
import com.example.forcaerp20.DashboardPage.approveFragment.ListApprovedAdapter
import com.example.forcaerp20.DashboardPage.approveFragment.listApprovedFragmentDirections
import com.example.forcaerp20.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class listApprovedFragment : Fragment() {

    private lateinit var recylerApprov: RecyclerView
    private lateinit var listApprovArray: ArrayList<ListApproved>
    private lateinit var tempArrayList: ArrayList<ListApproved>
    private lateinit var ApprovDrawerlayout: DrawerLayout


    lateinit var TypeApprovDocument: Array<String>
    lateinit var NameApprovDocument: Array<String>
    lateinit var NumberApprovDocument: Array<Int>
    lateinit var PartnerApprovDocument: Array<String>
    lateinit var NominalApprovDocument: Array<String>
    lateinit var DateApprovDocument: Array<String>
    lateinit var HistoryApprovDocument: Array<String>
    lateinit var DescriptionApprovDocument: Array<String>
    lateinit var StatusApprovDocument: Array<String>
    lateinit var adapter: ListApprovedAdapter

    var onStartDateSetListenerapprov: DatePickerDialog.OnDateSetListener? = null
    var onEndDateSetListenerapprov: DatePickerDialog.OnDateSetListener? = null
    var asc_approv: Boolean? = null
    var desc_approv: Boolean? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ApprovDrawerlayout = view.findViewById(R.id.drawer_layout_Approv)
        ApprovDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        var btnfilterApprov: Button = view.findViewById(R.id.BtnFilterApprov)

        btnfilterApprov.setOnClickListener {
            ApprovDrawerlayout.openDrawer(GravityCompat.END, true)
        }

        //contoh data
        TypeApprovDocument = arrayOf("AP Payment", "AP Payment", "AP Payment")
        NameApprovDocument = arrayOf(
            "Daxa Leave 2100016: idaF -555 ",
            "Forca Leave 2100016: idaF -46 ",
            "Barca Leave 2100016: idaF -466"
        )
        NumberApprovDocument = arrayOf(1234567, 2100018, 3958002)
        PartnerApprovDocument = arrayOf("Unair", "ITS", "Undip")
        NominalApprovDocument = arrayOf("0000", "2000", "1500")
        DateApprovDocument = arrayOf("16-1-2022", "01-1-2021", "16-10-2021")
        HistoryApprovDocument = arrayOf(
            "2021-12-16 12:02 :Indri Annisa Ghaida ([Start)\n" +
                    "2021-12-16 12:02 :Indri Annisa Ghaida\n" +
                    "((DocPrepare)]\n" +
                    "2021-12-16 12:02 :Donny Bustan Fauzi\n" +
                    "(Approve_Leader))\n" +
                    "2021-12-29 08:37:null ((Approve_Manager))\n" +
                    "2022-01-13 11:20 :Indri Annisa Ghaida\n" +
                    "((DocComplete))", "2021-12-28 12:18 :ndri Annisa Ghaida ((Start))\n" +
                    "2021-12-28 12:18 :Indri Annisa Ghaida\n" +
                    "(DocPrepare))", "24/01/2022 15.06 : Ariel Bintang Rafid ((Start))\n" +
                    "24/01/2022 15.06 : Ariel Bintang Rafid\n" +
                    "((DocPrepare))"
        )
        DescriptionApprovDocument = arrayOf(
            "mas Don, mas Fib. Indri izin ke Puskesmas mas.\n" +
                    "Mau cek batuk mas. batuk indri berdarah. mohon\n" +
                    "izin ya mas, makasi ya mas",
            "mas Don, mas Fib. Saya izin pulang karena demam",
            "mas Don saya izin untuk meminta approval document dari anak magang"
        )
        StatusApprovDocument = arrayOf("Approved", "Approved", "Rejected")

        listApprovArray = arrayListOf()
        tempArrayList = arrayListOf()
        tempArrayList.addAll(listApprovArray)

        for (i in NameApprovDocument.indices) {

            val ApprovDocumentList = ListApproved()
            ApprovDocumentList.TypeApprovDocument = TypeApprovDocument[i]
            ApprovDocumentList.NameApprovDocument = NameApprovDocument[i]
            ApprovDocumentList.NumberApprovDocument = NumberApprovDocument[i]
            ApprovDocumentList.BusinessApprovDocument = PartnerApprovDocument[i]
            ApprovDocumentList.NominalApprovDocument = NominalApprovDocument[i]
            ApprovDocumentList.DateApprovDocument = DateApprovDocument[i]
            ApprovDocumentList.HistoryApprovDocument = HistoryApprovDocument[i]
            ApprovDocumentList.DescriptionApprovDocument = DescriptionApprovDocument[i]
            ApprovDocumentList.StatusApprovDocument = StatusApprovDocument[i]
            listApprovArray.add(ApprovDocumentList)
        }


        recylerApprov = view.findViewById(R.id.approv_list_RecyclerView)
        recylerApprov.layoutManager = LinearLayoutManager(requireActivity())
        var adapter = ListApprovedAdapter(listApprovArray)
        recylerApprov.adapter = adapter

        adapter.setOnItemClickListener(object : ListApprovedAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val listToDetailApprov =
                    listApprovedFragmentDirections.actionListApprovedFragmentToDetailApprovedFragment(
                        documentTypeApprov = listApprovArray[position].TypeApprovDocument,
                        documentNameApprov = listApprovArray[position].NameApprovDocument,
                        documentNumberApprov = listApprovArray[position].NumberApprovDocument,
                        businessPartnerApprov = listApprovArray[position].BusinessApprovDocument,
                        documentNominalApprov = listApprovArray[position].NominalApprovDocument,
                        documentDateApprov = listApprovArray[position].DateApprovDocument,
                        documentHistoryApprov = listApprovArray[position].HistoryApprovDocument,
                        documentDescriptionApprov = listApprovArray[position].DescriptionApprovDocument,
                        documentStatusApprov = listApprovArray[position].StatusApprovDocument
                    )
                Navigation.findNavController(view)
                    .navigate(listToDetailApprov)
            }

        })

        var arrowBacktoApprovDash = view.findViewById<Button>(R.id.back_to_dashboardApprov)
        arrowBacktoApprovDash.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_listApprovedFragment_to_approvFragment)
        }


        //filter
            var fieldStartDateFilterApprov: AutoCompleteTextView = view.findViewById(R.id.StartDateApprov)
            var fieldEndDateFilterApprov: AutoCompleteTextView = view.findViewById(R.id.EndDateApprov)
            val calendar = Calendar.getInstance()
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]

            //select start date
            fieldStartDateFilterApprov.setOnClickListener {
                val datePickerDialog = DatePickerDialog(
                    requireActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,

                    onStartDateSetListenerapprov, year, month, day
                )
                datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                datePickerDialog.show()
            }
            onStartDateSetListenerapprov =
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
                    var month = month
                    month = month + 1
                    val date = "$dayofMonth/$month/$year"
                    fieldStartDateFilterApprov.setText(date)
                }

            fieldEndDateFilterApprov.setOnClickListener {
                val datePickerDialog = DatePickerDialog(
                    requireActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    onEndDateSetListenerapprov, year, month, day
                )
                datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                datePickerDialog.show() }

            //select end date
            onEndDateSetListenerapprov= DatePickerDialog.OnDateSetListener { datePicker, year, month, dayofMonth ->
                var month = month
                month = month + 1
                val date = "$dayofMonth/$month/$year"
                fieldEndDateFilterApprov.setText(date)}

            var FilterApprovSortGroup : RadioGroup = view.findViewById(R.id.RadioGroup_filterApprov)
            FilterApprovSortGroup.setOnCheckedChangeListener { radioGroup, Radio_id ->
                if (Radio_id == R.id.radioButton_AscApp){
                    asc_approv= true
                    desc_approv = false

                }
                else if (Radio_id == R.id.radioButton_DescApp){
                    desc_approv= true
                    asc_approv= false

                }
            }

            var btnFilterApp: Button = view.findViewById(R.id.filterSetApprov)

            btnFilterApp.setOnClickListener {
                val StartDate = fieldStartDateFilterApprov.text.toString().trim()
                val EndDate = fieldEndDateFilterApprov.text.toString().trim()
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
                if (StartDate != "dd/mm/yyyy" && EndDate != "dd/mm/yyyy" && asc_approv == true) {
                    Toast.makeText(
                        requireContext(),
                        "$StartDate & $EndDate with AZ",
                        Toast.LENGTH_SHORT
                    ).show()
                    Collections.sort(listApprovArray, ListApproved.sortByNameAZ)
                    adapter.notifyDataSetChanged()
                } else if (StartDate != "dd/mm/yyyy" && EndDate != "dd/mm/yyyy" && desc_approv == true) {
                    Collections.sort(listApprovArray, ListApproved.sortByNameZA)
                    Toast.makeText(
                        requireContext(),
                        "$StartDate & $EndDate with ZA",
                        Toast.LENGTH_SHORT
                    ).show()
                    adapter.notifyDataSetChanged()
                }
                //cuma milih tanggal
                else if (StartDate != "dd/mm/yyyy" && EndDate != "dd/mm/yyyy") {
                    Toast.makeText(requireContext(), "$StartDate & $EndDate", Toast.LENGTH_SHORT).show()
                }
                //cuma mencet tombol AZ
                else if (asc_approv == true) {
                    Collections.sort(listApprovArray, ListApproved.sortByNameAZ)
                    Toast.makeText(requireContext(), "A to Z", Toast.LENGTH_SHORT).show()
                    adapter.notifyDataSetChanged()
                }
                //cuma mencet tombol ZA
                else if (desc_approv == true) {
                    Collections.sort(listApprovArray, ListApproved.sortByNameZA)
                    Toast.makeText(requireContext(), "Z to A", Toast.LENGTH_SHORT).show()
                    adapter.notifyDataSetChanged()
                }
                ApprovDrawerlayout.closeDrawers()
            }

            var btnClearFilterApprov: Button = view.findViewById(R.id.filterClearApprov)
            btnClearFilterApprov.setOnClickListener {
                FilterApprovSortGroup.clearCheck()
                fieldStartDateFilterApprov.setText("dd/mm/yyyy")
                fieldEndDateFilterApprov.setText("dd/mm/yyyy")
                asc_approv = false
                desc_approv = false
    //                recylerPending.layoutManager
    //                recylerPending.layoutManager = LinearLayoutManager(requireActivity())
    //                adapter = ListPendingAdapter(listPendingArray)
    //                recylerPending.adapter = adapter
            }

        //Doc Approved
        var textTypeDoc = view.findViewById<AutoCompleteTextView>(R.id.DocStaApprov)
        val DocSta = resources.getStringArray(R.array.DocStaApprov)
        val tesAdapter = ArrayAdapter(requireActivity(), R.layout.dropdown_temp, DocSta)
        textTypeDoc.setAdapter(tesAdapter)

        }

        //filter class
        fun filterDateRange(charText: Date, charText1: Date) {
            listApprovArray.clear()
            if (charText.equals("") || charText.equals(null)) {
                listApprovArray.addAll(tempArrayList)
            } else {
                for (wp in tempArrayList) {
                    val sdf = SimpleDateFormat("yyyy-MM-dd")
                    try {
                        val strDate: Date = sdf.parse(wp.DateApprovDocument)
                        if (charText1.after(strDate) && charText.before(strDate)) {
                            listApprovArray.add(wp)
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
        return inflater.inflate(R.layout.fragment_list_approved, container, false)
    }
}
