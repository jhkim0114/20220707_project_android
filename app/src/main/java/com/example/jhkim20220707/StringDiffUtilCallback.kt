package com.example.jhkim20220707

import androidx.recyclerview.widget.DiffUtil

class StringDiffUtilCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem && oldItem == newItem
    }
}