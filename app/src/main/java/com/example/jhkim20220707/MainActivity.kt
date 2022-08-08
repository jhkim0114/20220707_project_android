package com.example.jhkim20220707

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jhkim20220707.databinding.ActivityMainBinding
import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class User(val name: String, val age: String)

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val boardAdapter = BoardAdapter()
        binding.recyclerView.adapter = boardAdapter

        val arrayList = mutableListOf<String>()
        arrayList.add("test1")
        arrayList.add("test2")
        arrayList.add("test3")
        boardAdapter.submitList(arrayList)
        test()
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
}