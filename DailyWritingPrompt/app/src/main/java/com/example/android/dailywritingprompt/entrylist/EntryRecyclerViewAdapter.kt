package com.example.android.dailywritingprompt.entrylist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android.dailywritingprompt.databinding.FragmentEntryItemBinding
import com.example.android.dailywritingprompt.databinding.FragmentEntryListBinding
import com.example.android.dailywritingprompt.models.Entry

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 */
class EntryRecyclerViewAdapter(private val clickListener: EntryListener) :
    ListAdapter<Entry, EntryRecyclerViewAdapter.EntryViewHolder>(DiffCallback){

    companion object DiffCallback : DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem.entryId == newItem.entryId
        }
    }

    class EntryViewHolder(var binding: FragmentEntryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(entry: Entry) {
            binding.entryObject = entry
            binding.executePendingBindings()
        }
    }

    class EntryListener(val clickListener: (entry: Entry) -> Unit) {
        fun onClick(entry: Entry) = clickListener(entry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val withDataBinding: FragmentEntryItemBinding = FragmentEntryItemBinding
            .inflate(LayoutInflater.from(parent.context))
        return EntryViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = getItem(position)

        holder.also {
            it.itemView.setOnClickListener {
                clickListener.onClick(entry)
            }
            it.bind(entry)
        }
    }

}