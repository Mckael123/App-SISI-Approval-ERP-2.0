package com.example.forcaerp20.DashboardPage.approveFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.DashboardPage.pendingFragment.ListPending
import com.example.forcaerp20.DashboardPage.pendingFragment.ListPendingAdapter
import com.example.forcaerp20.NewsPage.ItemAdapter
import com.example.forcaerp20.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ListApprovedAdapter(private val Approvlist:ArrayList<ListApproved>): RecyclerView.Adapter<ListApprovedAdapter.ApprovedViewHolder>() {
    var dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    class ApprovedViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var NameApprovDocument: TextView = itemView.findViewById(R.id.DocumentNameApprov)
        var DateApprovDocument: TextView = itemView.findViewById(R.id.DocumentDateApprov)

        //constructor
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
    private lateinit var ListListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        ListListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApprovedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.aprrov_list_item, parent, false)
        return ApprovedViewHolder(view,ListListener)
    }

    //sus
    override fun onBindViewHolder(holder: ApprovedViewHolder, position: Int) {
        val currentItem = Approvlist[position]
        holder.NameApprovDocument.text = currentItem.NameApprovDocument
        holder.DateApprovDocument.text = currentItem.DateApprovDocument
    }

    override fun getItemCount(): Int {
        return Approvlist.size
    }
}