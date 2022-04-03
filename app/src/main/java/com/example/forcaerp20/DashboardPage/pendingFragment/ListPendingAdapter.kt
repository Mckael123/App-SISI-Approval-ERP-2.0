package com.example.forcaerp20.DashboardPage.pendingFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.NewsPage.ItemAdapter
import com.example.forcaerp20.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ListPendingAdapter(private val Pendinglist:ArrayList<ListPending>): RecyclerView.Adapter<ListPendingAdapter.PendingViewHolder>() {
    var dateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
    class PendingViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var NamePendingDocument: TextView = itemView.findViewById(R.id.DocumentName)
        var DatePendingDocument: TextView = itemView.findViewById(R.id.DocumentDate)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pending_list_item, parent, false)
        return PendingViewHolder(view,ListListener)
    }

    //sus
    override fun onBindViewHolder(holder: PendingViewHolder, position: Int) {
        val currentItem = Pendinglist[position]
        holder.NamePendingDocument.text = currentItem.NamePendingDocument
        holder.DatePendingDocument.text = currentItem.DatePendingDocument
    }

    override fun getItemCount(): Int {
        return Pendinglist.size
    }


}