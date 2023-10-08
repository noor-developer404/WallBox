package com.developer404.wallbox

import android.app.ActionBar
import android.app.WallpaperManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.developer404.wallbox.databinding.ActivitySetWallpaperBinding
import com.squareup.picasso.Picasso
import kotlin.concurrent.thread


class set_wallpaper : AppCompatActivity() {
    lateinit var binding:ActivitySetWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding=ActivitySetWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        window.insetsController.setSystemBarsAppearance()

//        setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)

        var name = intent.getStringExtra("wall_name")
        Picasso.get().load("http://192.168.194.30/wallbox/wallpapers/" +name).into(binding.setWallImg)
        binding.SetWallBtn.setOnClickListener(View.OnClickListener {
            binding.SetWallBtn.setText("Applied")
            thread {
                var bitmap = Picasso.get().load("http://192.168.194.30/wallbox/wallpapers/" +name).get()
                WallpaperManager.getInstance(this).setBitmap(bitmap)
            }

        })
    }
}