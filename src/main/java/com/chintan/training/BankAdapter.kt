package com.chintan.training

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BankAdapter(var mContext:Context,var mBankList: ArrayList<BankSmsModel>,var mClickListener:ClickListener):RecyclerView.Adapter<BankAdapter.BankViewHolder>() {
    class BankViewHolder(view:View):RecyclerView.ViewHolder(view){
        var mTVBank:TextView = view.findViewById(R.id.mTVBank)
    }
    interface ClickListener{
        fun onItemClick(position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_bank,parent,false)
        return BankViewHolder(view)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        val list = mBankList[position]
        holder.mTVBank.text = list.mBankName
        holder.itemView.setOnClickListener {
            mClickListener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int = mBankList.size
}