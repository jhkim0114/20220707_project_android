package com.example.jhkim20220707

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jhkim20220707.databinding.ActivityMainBinding

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


    }
}