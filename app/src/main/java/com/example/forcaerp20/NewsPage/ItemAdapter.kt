package com.example.forcaerp20.NewsPage


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.R

class ItemAdapter(private val newslist:ArrayList<Item>) : RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView:View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
        var judul: TextView = itemView.findViewById(R.id.item_judul_berita)
        var tanggal:TextView = itemView.findViewById(R.id.item_tanggal_berita)
        var image: ImageView = itemView.findViewById(R.id.item_foto)
        //        var isi: TextView = itemView.findViewById(R.id.item_detail)

        //constructor
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }

    private lateinit var mListener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }

    //untuk ngeset tampilan layout dari item yang akan muncul pada recyle view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_news, parent, false)
        return MyViewHolder(view,mListener)

    }

    //untuk masukin data yang ada di array pada tempat penampungan data di class Item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newslist[position]
        holder.judul.text = currentItem.judul
        holder.image.setImageResource(currentItem.image)
        holder.tanggal.text = currentItem.tanggal
//        holder.isi.text= currentItem.isi
    }


    //menentukan jumlah array(index)
    override fun getItemCount(): Int {
        return newslist.size
    }
}