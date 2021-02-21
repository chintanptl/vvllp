package com.chintan.training

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SmsAdapter(var mContext: Context, var mSmsList: ArrayList<String>, var mClickListener:ClickListener):
    RecyclerView.Adapter<SmsAdapter.SmsViewHolder>() {
    class SmsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val mTVSms: TextView = view.findViewById(R.id.mTVSms)
    }
    interface ClickListener{
        fun onItemClick(position:String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_sms,parent,false)
        return SmsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SmsViewHolder, position: Int) {
        val list = mSmsList[position]
        holder.mTVSms.text = list
        holder.itemView.setOnClickListener {
            mClickListener.onItemClick(list)
        }
    }

    override fun getItemCount(): Int = mSmsList.size
}