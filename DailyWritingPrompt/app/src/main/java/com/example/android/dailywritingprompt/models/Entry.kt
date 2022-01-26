package com.example.android.dailywritingprompt.models

import java.util.ArrayList
import java.util.HashMap

object Entry {
    val ITEMS: MutableList<EntryItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, EntryItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createEntryItem(i))
        }
    }

    private fun addItem(item: EntryItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.entryTitle, item)
    }

    private fun createEntryItem(position: Int): EntryItem {
        return EntryItem(
            position.toString(),
            "Item " + position,
            "100 words",
            "5 minutes",
            1

        )
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }
}

data class EntryItem(
    //TODO: I changed some of these to string because i assume it'll be better
    // for me to parse them into strings for the sake of better readability in the UI.
    // If this is wrong though, change them back to Int, Float, respectively
    val entryTitle: String = "",
    val entryPreview: String = "",
    val wordCount: String,
    val writeTime: String,
    val entryId: Int
)