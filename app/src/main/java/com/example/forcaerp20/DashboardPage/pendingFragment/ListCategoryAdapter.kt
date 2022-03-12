package com.example.forcaerp20.DashboardPage.pendingFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.NewsPage.Item
import com.example.forcaerp20.NewsPage.ItemAdapter

import com.example.forcaerp20.R

class ListCategoryAdapter(private val CategoryPendinglist:ArrayList<CategoryPending>): RecyclerView.Adapter<ListCategoryAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var NameCategory: TextView = itemView.findViewById(R.id.TypeDocumentPending)
        var CountPendingCategory: TextView = itemView.findViewById(R.id.CountID)

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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return MyViewHolder(view,CListener)

    }

    //untuk masukin data yang ada di array pada tempat penampungan data di class Item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = CategoryPendinglist[position]
        holder.NameCategory.text = currentItem.NameCategory
        holder.CountPendingCategory.text = currentItem.CountPendingCategory.toString()


    }


    //menentukan jumlah array(index)
    override fun getItemCount(): Int {
        return CategoryPendinglist.size
    }
}