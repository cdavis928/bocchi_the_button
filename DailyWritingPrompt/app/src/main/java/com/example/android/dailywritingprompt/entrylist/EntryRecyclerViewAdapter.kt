package com.example.android.dailywritingprompt.entrylist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.dailywritingprompt.databinding.FragmentEntryItemBinding
import com.example.android.dailywritingprompt.databinding.FragmentEntryListBinding
import com.example.android.dailywritingprompt.models.EntryItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class EntryRecyclerViewAdapter(
    private val entries: MutableList<EntryItem>
) : RecyclerView.Adapter<EntryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //TODO: according to the android docs, this is where we can modify behavior for each list item
        return ViewHolder(
            FragmentEntryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //TODO: delete this test later
        val item = EntryItem(
            "time stamp as title goes here",
            "preview text...",
            "100 words",
            "5 minutes",
            1
        )


//        val item = entries[position]
        holder.idView.text = item.entryTitle
        holder.contentView.text = item.entryPreview
        holder.wordCountView.text = item.wordCount
        holder.writeTimeView.text = item.writeTime
    }

    override fun getItemCount(): Int = entries.size

    inner class ViewHolder(binding: FragmentEntryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.entryTitle
        val contentView: TextView = binding.entryPreview
        val wordCountView: TextView = binding.wordCount
        val writeTimeView: TextView = binding.writeTime

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}