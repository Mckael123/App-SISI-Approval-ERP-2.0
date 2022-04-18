package com.example.forcaerp20.DashboardPage.approveFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


import com.example.forcaerp20.R

class ListCategory2Adapter (private val CategoryApprovlist:ArrayList<CategoryApproved>): RecyclerView.Adapter<ListCategory2Adapter.MyViewHolder>() {
    class MyViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var NameCategoryApprov: TextView = itemView.findViewById(R.id.TypeDocumentApprov)
        var CountApprovCategory: TextView = itemView.findViewById(R.id.CountIDApprov)

        //constructor
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
    private lateinit var CListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        CListener=listener
    }

    //untuk ngeset tampilan layout dari item yang akan muncul pada recyle view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category2_list_item, parent, false)
        return MyViewHolder(view,CListener)
    }

    //untuk masukin data yang ada di array pada tempat penampungan data di class Item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = CategoryApprovlist[position]
        holder.NameCategoryApprov.text = currentItem.NameCategoryApprov
        holder.CountApprovCategory.text = currentItem.CountApprovCategory.toString()
    }


    //menentukan jumlah array(index)
    override fun getItemCount(): Int {
        return CategoryApprovlist.size
    }

}