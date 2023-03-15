package com.example.marsrover.view.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marsrover.MAIN
import com.example.marsrover.R
import com.example.marsrover.model.Photo

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.SavedViewHolder>() {

    private var listPhoto = emptyList<Photo>()

    class SavedViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_photos, parent, false)
        return SavedViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.CardDate).text = listPhoto[position].earth_date

        Glide.with(MAIN)
            .load(listPhoto[position].img_src)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.findViewById(R.id.cardImage))
    }

    override fun getItemCount(): Int {
        return listPhoto.size
    }

    fun setList(list: List<Photo>) {
        listPhoto = list
        notifyItemChanged(1)
    }

    fun getItem(position: Int): Photo = listPhoto[position]
}