package com.example.forcaerp20.DashboardPage.pendingFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.R


class ListPendingFragment : Fragment() {

    private lateinit var recylerPending: RecyclerView
    private lateinit var listPendingArray: ArrayList<ListPending>

    lateinit var TypeDocument: Array<String>
    lateinit var NameDocument: Array<String>
    lateinit var NumberDocument: Array<Int>
    lateinit var PartnerDocument: Array<String>
    lateinit var NominalDocument: Array<String>
    lateinit var DateDocument: Array<String>
    lateinit var HistoryDocument: Array<String>
    lateinit var DescriptionDocument: Array<String>
    lateinit var StatusDocument: Array<String>



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //contoh data
        TypeDocument= arrayOf("AP Payment","AP Payment","AP Payment")
        NameDocument = arrayOf(
            "Forca Leave 2100016: idaF -46 ",
            "Daxa Leave 2100016: idaF -555 ",
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

        var adapter = ListPendingAdapter(listPendingArray)
        recylerPending = view.findViewById(R.id.pending_list_RecyclerView)
        recylerPending.layoutManager = LinearLayoutManager(requireActivity())
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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_pending, container, false)
    }


}