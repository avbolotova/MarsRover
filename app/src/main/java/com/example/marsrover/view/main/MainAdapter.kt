package com.example.marsrover.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marsrover.MAIN
import com.example.marsrover.R
import com.example.marsrover.model.Photo

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listPhotos = emptyList<Photo>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_add, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(MAIN)
            .load(listPhotos[position].img_src)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.itemView.findViewById(R.id.eachImage))
    }

    override fun getItemCount(): Int {
        return listPhotos.size
    }
    fun setList(list: List<Photo>) {
        listPhotos = list
        notifyItemChanged(1)
    }

        override fun onViewAttachedToWindow(holder: MyViewHolder) {
            super.onViewAttachedToWindow(holder)
            holder.itemView.setOnClickListener {
                MainFragment.clickFilms(listPhotos[holder.adapterPosition])
            }
        }
    }