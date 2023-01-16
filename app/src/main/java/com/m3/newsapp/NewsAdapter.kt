package com.m3.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m3.newsapp.api.model.ArticlesItem

class NewsAdapter( var newslist:List<ArticlesItem?>?) :RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        val date:TextView=itemView.findViewById(R.id.date)
        val title:TextView=itemView.findViewById(R.id.title)
        val desc:TextView=itemView.findViewById(R.id.desc)
        val image:ImageView=itemView.findViewById(R.id.image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view= LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
            return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem= newslist?.get(position)
        holder.date.setText(newsItem?.publishedAt)
        holder.title.setText(newsItem?.title)
        holder.desc.setText(newsItem?.description)




    }
    fun changeData(newslist: List<ArticlesItem?>?){

        this.newslist=newslist
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
    return newslist?.size?:0
        }
}