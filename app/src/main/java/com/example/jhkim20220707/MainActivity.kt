package com.example.jhkim20220707

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.jhkim20220707.databinding.ActivityMainBinding
import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class User(val name: String, val age: String)

class MainActivity : AppCompatActivity() {

    private lateinit var circleAnimIndicator: CircleAnimIndicator


    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {

//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val boardAdapter = BoardAdapter()
//        binding.recyclerView.adapter = boardAdapter
//
//        val arrayList = mutableListOf<String>()
//        arrayList.add("test1")
//        arrayList.add("test2")
//        arrayList.add("test3")
//        boardAdapter.submitList(arrayList)
//        test()

        binding.viewPager.adapter = ViewPagerAdapter(getList())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.d("hoho postion", position.toString())
                Log.d("hoho positionOffset", positionOffset.toString())
                Log.d("hoho positionOffsetPixels", positionOffsetPixels.toString())

                circleAnimIndicator.selectDot(position);


            }
        })

        circleAnimIndicator = binding.circleAnimIndicator
        initIndicaotor()

    }

    private fun getList() : ArrayList<String> {
        return arrayListOf<String>("test1", "test2", "test3")
    }

    fun test() {
        val user = User("jiho", "37")
        val string = Json.encodeToString(user)
        Log.d("hoho", string)
//        println(string)
        val obj = Json.decodeFromString<User>(string)
//        print(obj)
        Log.d("hoho", obj.toString())
    }

     /**

         * Indicator 초기화
         */
        private fun initIndicaotor(){
         
                //원사이의 간격

                circleAnimIndicator.setItemMargin(15);
                //애니메이션 속도

                circleAnimIndicator.setAnimDuration(300);
                //indecator 생성

                circleAnimIndicator.createDotPanel(3, R.drawable.ic_baseline_circle_24_white , R.drawable.ic_baseline_circle_24_yellow);
            }
}