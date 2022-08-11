package com.example.jhkim20220707

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jhkim20220707.databinding.ItemBinding

class ViewPagerAdapter(idolList: ArrayList<String>) : ListAdapter<String, ViewPagerAdapter.PagerViewHolder>(StringDiffUtilCallback()) {

    private lateinit var binding: ItemBinding
    var item = idolList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(item[position])
    }

    class PagerViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun  bind(txt: String) {
            binding.textView.text = txt
        }

    }
//        (LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)){
//            val textView = binding.textView
//
////        val idol = itemView.text
//    }
}