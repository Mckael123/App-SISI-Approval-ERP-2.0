package com.example.forcaerp20.DashboardPage.approveFragment

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


class detailApprovedFragment : Fragment() {

    val detailArgumentvarApproved: detailApprovedFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ApprovDocType = detailArgumentvarApproved.documentTypeApprov
        val ApprovDocName = detailArgumentvarApproved.documentNameApprov
        val ApprovDocNumber= detailArgumentvarApproved.documentNumberApprov
        val ApprovBusinessPartner = detailArgumentvarApproved.businessPartnerApprov
        val ApprovDocNominal = detailArgumentvarApproved.documentNominalApprov
        val ApprovDocDate = detailArgumentvarApproved.documentDateApprov
        val ApprovDocHistory = detailArgumentvarApproved.documentHistoryApprov
        val ApprovDocDesc = detailArgumentvarApproved.documentDescriptionApprov
        val ApprovDocStatus = detailArgumentvarApproved.documentStatusApprov

        var TVapprovType = view.findViewById<TextView>(R.id.approvTVtype)
        var TvapprovName = view.findViewById<TextView>(R.id.approvtvnamedoc)
        var TvapprovNumber = view.findViewById<TextView>(R.id.approvTVnumber)
        var TvapprovBusiness = view.findViewById<TextView>(R.id.approvTVbusiness)
        var TvapprovNominal = view.findViewById<TextView>(R.id.approvTVnominal)
        var TvapprovDate = view.findViewById<TextView>(R.id.approvTVDate)
        var TvapprovHistory = view.findViewById<TextView>(R.id.approvTvhistory)
        var TvapprovDesc = view.findViewById<TextView>(R.id.approvTVdesc)
        var TvapprovStatus = view.findViewById<TextView>(R.id.approvTVstatus)

        TVapprovType.setText(ApprovDocType)
        TvapprovName.setText(ApprovDocName)
        TvapprovNumber.setText(ApprovDocNumber.toString())
        TvapprovBusiness.setText(ApprovBusinessPartner)
        TvapprovNominal.setText(ApprovDocNominal)
        TvapprovDate.setText(ApprovDocDate)
        TvapprovHistory.setText(ApprovDocHistory)
        TvapprovDesc.setText(ApprovDocDesc)
        TvapprovStatus.setText(ApprovDocStatus)


        var btn_confrim:Button = view.findViewById(R.id.ButtonConfirmApprov)

        btn_confrim.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailApprovedFragment_to_listApprovedFragment)
        }

        var arrowBacktoApprovList = view.findViewById<Button>(R.id.back_to_ListApprov)
        arrowBacktoApprovList .setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_detailApprovedFragment_to_listApprovedFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_approved, container, false)
    }

}