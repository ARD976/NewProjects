package com.example.dsachat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.dsa_activity.view.*
import java.util.ArrayList

class DSAdapter(val context: Context) : RecyclerView.Adapter<DSViewHolder>(){

    private var dsaList = ArrayList<DSA>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DSViewHolder {
        return DSViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.dsa_activity , parent , false))
    }

    override fun onBindViewHolder(holder: DSViewHolder, position: Int) {
        val currentItem = dsaList[position]
        holder.apply {
            type.text = currentItem.type
            count.text = currentItem.count.toString()
            date.text = currentItem.date
            edit.setOnClickListener {
                if(context is MainActivity)
                    context.addUpdateDialog(currentItem)
            }
            delete.setOnClickListener {
                if(context is MainActivity)
                    context.addDeleteDialog(currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return dsaList.size
    }

    fun updateList(list : ArrayList<DSA>){
        dsaList.clear()
        dsaList = list
        notifyDataSetChanged()
    }

}

class DSViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val type = view.tvDsa
    val count = view.tvCount
    val date = view.tvDate
    val edit = view.create
    val delete = view.delete
}