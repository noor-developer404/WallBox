package com.developer404.wallbox

import android.content.Intent
import android.graphics.Path.Direction
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.ErrorListener
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.developer404.wallbox.databinding.ActivityMainBinding
import com.developer404.wallbox.other.main_adapter
import com.developer404.wallbox.other.response
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var array:Array<response>
    var lightArray:ArrayList<String> =ArrayList()
    var darkArray:ArrayList<String> =ArrayList()
    var blueArray:ArrayList<String> =ArrayList()
    var greenArray:ArrayList<String> =ArrayList()
    var redArray:ArrayList<String> =ArrayList()
    var orangeArray:ArrayList<String> =ArrayList()
    var trendingArray:ArrayList<String> =ArrayList()
    var natureArray:ArrayList<String> =ArrayList()
    var carsArray:ArrayList<String> =ArrayList()
    var bikesArray:ArrayList<String> =ArrayList()
    var vectorsArray:ArrayList<String> =ArrayList()
    var animalsArray:ArrayList<String> =ArrayList()
    var citiesArray:ArrayList<String> =ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainColorLight.setOnClickListener(this)
        binding.mainColorDark.setOnClickListener(this)
        binding.mainColorBlue.setOnClickListener(this)
        binding.mainColorGreen.setOnClickListener(this)
        binding.mainColorRed.setOnClickListener(this)
        binding.mainColorOrange.setOnClickListener(this)
        binding.mainSeeNature.setOnClickListener(this)
        binding.mainSeeCars.setOnClickListener(this)
        binding.mainSeeBikes.setOnClickListener(this)
        binding.mainSeeVectors.setOnClickListener(this)
        binding.mainSeeAnimals.setOnClickListener(this)
        binding.mainSeeCities.setOnClickListener(this)
        binding.mainSeeTrending.setOnClickListener(this)



        val url = "http://192.168.194.30/wallbox/fetch.php"
        Volley.newRequestQueue(this).add(JsonArrayRequest(Request.Method.GET,url,null,
            {
                for (i in 0..it.length()){
                    var jsonobject = it.getJSONObject(i)
                   var category= jsonobject.get("category")
                    var color =jsonobject.get("color")
                    var rating = jsonobject.get("rating")
                    var wall_name=jsonobject.get("wallpaper")
                    when(color){
                        "light"->{lightArray.add(wall_name.toString())}
                        "dark"->{darkArray.add(wall_name.toString())}
                        "blue"->{blueArray.add(wall_name.toString())}
                        "green"->{greenArray.add(wall_name.toString())}
                        "red"->{redArray.add(wall_name.toString())}
                        "orange"->{orangeArray.add(wall_name.toString())}

                    }
                    when(category){
                        "nature"->{natureArray.add(wall_name.toString())}
                        "cars"->{carsArray.add(wall_name.toString())}
                        "bikes"->{bikesArray.add(wall_name.toString())}
                        "vectors"->{vectorsArray.add(wall_name.toString())}
                        "animals"->{animalsArray.add(wall_name.toString())}
                        "cities"->{citiesArray.add(wall_name.toString())}

                    }
                    if (Integer.parseInt(rating.toString()) >8){
                        trendingArray.add(wall_name.toString())
                    }
                }
                setting_adapters()
            }, {
            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
//            Log.e("volley", "onCreate: "+it.toString(), )
        }))

    }

    private fun setting_adapters() {
        binding.mainTrendingRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainTrendingRv.adapter= main_adapter(this,trendingArray)

        binding.mainNatureRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainNatureRv.adapter= main_adapter(this,natureArray)

        binding.mainCarsRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainCarsRv.adapter= main_adapter(this,carsArray)

        binding.mainBikesRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainBikesRv.adapter= main_adapter(this,bikesArray)

        binding.mainVectorsRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainVectorsRv.adapter= main_adapter(this,vectorsArray)

        binding.mainAnimalsRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainAnimalsRv.adapter= main_adapter(this,animalsArray)

        binding.mainCitiesRv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mainCitiesRv.adapter= main_adapter(this,citiesArray)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.main_see_nature-> {
                    var intent = Intent(this,See_all::class.java)
                    startActivity(intent)
                }
                R.id.main_see_cars-> {var intent = Intent(this,See_all::class.java)
                    startActivity(intent)}
                R.id.main_see_bikes-> {var intent = Intent(this,See_all::class.java)
                    startActivity(intent)}
                R.id.main_see_vectors-> {var intent = Intent(this,See_all::class.java)
                    startActivity(intent)}
                R.id.main_see_animals-> {var intent = Intent(this,See_all::class.java)
                    startActivity(intent)}
                R.id.main_see_cities-> {var intent = Intent(this,See_all::class.java)
                    startActivity(intent)}

            }
        }
    }
}