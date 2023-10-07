package com.developer404.wallbox.other

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer404.wallbox.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class see_all_adapter(var context: Context, var array: Array<response>) :
    RecyclerView.Adapter<see_all_adapter.holder>() {

    class holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageview: ShapeableImageView = itemView.findViewById(R.id.see_all_item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        var view=LayoutInflater.from(context).inflate(R.layout.see_all_item,parent,false)
        return holder(view)
    }

    override fun getItemCount(): Int {
       return array.size
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        Picasso.get().load("http://find10.in/wallbox/wallpapers/" + this.array.get(position)).into(holder.imageview)
    }
}