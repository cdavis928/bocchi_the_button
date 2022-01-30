package com.example.android.dailywritingprompt.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO: you will want to update this later to include qualities user can filter by.
// For now lets leave it simple and just use a getAll type function in the Dao
//@Entity(tableName = "writing_entry_table")
//data class DatabaseEntry(
//    @PrimaryKey(autoGenerate = true)
//    val entryTitle: String,
//    val entryPreview: String,
//    val wordCount: String,
//    val writeTime: String,
//    val entryId: Int
//
//)