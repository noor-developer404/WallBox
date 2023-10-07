package com.developer404.wallbox.other

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer404.wallbox.R
import com.developer404.wallbox.set_wallpaper
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class main_adapter(var context: Context, var array: ArrayList<String>) :
    RecyclerView.Adapter<main_adapter.holder>() {


    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagview:ShapeableImageView = itemView.findViewById(R.id.wall_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        var view = LayoutInflater.from(context).inflate(R.layout.wall_item,parent,false)
        return holder(view)
    }

    override fun getItemCount(): Int {
        return array.size;
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
       Picasso.get().load("http://find10.in/wallbox/wallpapers/" + this.array.get(position)).into(holder.imagview)
        holder.itemView.setOnClickListener(View.OnClickListener {
            var intent = Intent(context,set_wallpaper::class.java)
            intent.putExtra("wall_name",array[position])
            context.startActivity(intent)
        })
    }
}