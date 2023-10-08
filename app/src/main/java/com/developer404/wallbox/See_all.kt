package com.developer404.wallbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.developer404.wallbox.databinding.ActivitySeeAllBinding
import com.developer404.wallbox.other.response
import com.developer404.wallbox.other.see_all_adapter

class See_all : AppCompatActivity() {
    lateinit var binding: ActivitySeeAllBinding
    var array :ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeeAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        array = intent.getStringArrayListExtra("array")!!
//        binding.seeAllToolbar.title=intent.getStringExtra("category")
        binding.seeAllRv.layoutManager=GridLayoutManager(this,2)
        binding.seeAllRv.adapter=see_all_adapter(this,array)
    }
}