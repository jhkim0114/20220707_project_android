package com.example.jhkim20220707

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jhkim20220707.databinding.ItemBinding

class BoardAdapter: ListAdapter<String, BoardAdapter.BoardViewHolder>(ItemDiffUtilCallback()) {

    private lateinit var binding: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BoardViewHolder(
        private val binding: ItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String) {
            binding.textView.text = text
            binding.textView.setOnClickListener {
                Toast.LENGTH_SHORT

            }
        }
    }

}