package com.chintan.training

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ListAdapter(var mContext: Context,var mBookList:ArrayList<Book>):RecyclerView.Adapter<ListAdapter.ListViewHolder>(){
    class ListViewHolder(view:View):RecyclerView.ViewHolder(view){
        var mIVBookImage:ImageView = view.findViewById(R.id.mIVBookImage)
        var mTVBookName:TextView = view.findViewById(R.id.mTVBookName)
        var mTVBookAuthor:TextView = view.findViewById(R.id.mTVBookAuthor)
        var mTVBookPrice:TextView = view.findViewById(R.id.maTVBookPrice)
        var mTVBookRating:TextView = view.findViewById(R.id.mTVBookRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_row_linear_layout,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var book = mBookList[position]

        holder.mTVBookName.text = book.mBookName
        holder.mTVBookAuthor.text = book.mBookAuthor
        holder.mTVBookPrice.text = book.mBookPrice
        holder.mTVBookRating.text = book.mBookRating
        Picasso.get().load(book.mBookImage).placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground).into(holder.mIVBookImage)
    }

    override fun getItemCount(): Int = mBookList.size
}