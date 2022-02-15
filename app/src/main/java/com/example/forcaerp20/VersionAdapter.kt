package com.example.forcaerp20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionAdapter (val versionList: List<Versions>) :
        RecyclerView.Adapter<VersionAdapter.VersionVH>(){
    class VersionVH (itemView: View) : RecyclerView.ViewHolder(itemView){

        var codeNameTxt : TextView = itemView.findViewById(R.id.code_name)
        var descriptionTxt : TextView = itemView.findViewById(R.id.description)
        var linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expandablelayout : RelativeLayout = itemView.findViewById(R.id.expandable_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionVH {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_faq, parent,false)

        return VersionVH(view)
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    override fun onBindViewHolder(holder: VersionVH, position: Int) {

        val versions : Versions = versionList[position]
        holder.codeNameTxt.text = versions.codeName
        holder.descriptionTxt.text = versions.description

        val isExpandable : Boolean = versionList[position].expandable
        holder.expandablelayout.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener {
            val versions = versionList[position]
            versions.expandable = !versions.expandable
            notifyItemChanged(position)
        }
    }
}