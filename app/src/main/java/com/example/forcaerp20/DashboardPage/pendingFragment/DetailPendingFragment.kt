package com.example.forcaerp20.DashboardPage.pendingFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.forcaerp20.NewsPage.DetailNewsFragmentArgs
import com.example.forcaerp20.R


class DetailPendingFragment : Fragment() {

    val detailArgumentvar: DetailPendingFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pendingDocType = detailArgumentvar.documentType
        val pendingDocName = detailArgumentvar.documentName
        val pendingDocNumber= detailArgumentvar.documentNumber
        val pendingBusinessPartner = detailArgumentvar.businessPartner
        val pendingDocNominal = detailArgumentvar.documentNominal
        val pendingDocDate = detailArgumentvar.documentDate
        val pendingDocHistory = detailArgumentvar.documentHistory
        val pendingDocDesc = detailArgumentvar.documentDescription
        val pendingDocStatus = detailArgumentvar.documentStatus

        var TVPendingType = view.findViewById<TextView>(R.id.pendingTVtype)
        var TvPendingName = view.findViewById<TextView>(R.id.tvnamedoc)
        var TvPendingNumber = view.findViewById<TextView>(R.id.pendingTVnumber)
        var TvPendingBusiness = view.findViewById<TextView>(R.id.pendingTVbusiness)
        var TvPendingNominal = view.findViewById<TextView>(R.id.pendingTVnominal)
        var TvPendingDate = view.findViewById<TextView>(R.id.pendingTVDate)
        var TvPendingHistory = view.findViewById<TextView>(R.id.pendingTvhistory)
        var TvPendingDesc = view.findViewById<TextView>(R.id.pendingTVdesc)
        var TvPendingStatus = view.findViewById<TextView>(R.id.pendingTVstatus)

        TVPendingType.setText(pendingDocType)
        TvPendingName.setText(pendingDocName)
        TvPendingNumber.setText(pendingDocNumber.toString())
        TvPendingBusiness.setText(pendingBusinessPartner)
        TvPendingNominal.setText(pendingDocNominal)
        TvPendingDate.setText(pendingDocDate)
        TvPendingHistory.setText(pendingDocHistory)
        TvPendingDesc.setText(pendingDocDesc)
        TvPendingStatus.setText(pendingDocStatus)


        var btn_accept:Button = view.findViewById(R.id.ButtonAcceptPending)
        var btn_reject:Button = view.findViewById(R.id.ButtonRejectPending)

        btn_accept.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailPendingFragment_to_listPendingFragment)
        }

        btn_reject.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailPendingFragment_to_listPendingFragment)
        }

        var arrowBacktoPendingList = view.findViewById<Button>(R.id.back_to_ListPending)
        arrowBacktoPendingList .setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailPendingFragment_to_listPendingFragment)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_pending, container, false)
    }

}