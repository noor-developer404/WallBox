package com.developer404.wallbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.developer404.wallbox.databinding.ActivitySetWallpaperBinding
import com.squareup.picasso.Picasso

class set_wallpaper : AppCompatActivity() {
    lateinit var binding:ActivitySetWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySetWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("wall_name")
        Picasso.get().load("http://find10.in/wallbox/wallpapers/" +name).into(binding.setWallImg)

        binding.SetWallBtn.setOnClickListener(View.OnClickListener {
            
        })
    }
}