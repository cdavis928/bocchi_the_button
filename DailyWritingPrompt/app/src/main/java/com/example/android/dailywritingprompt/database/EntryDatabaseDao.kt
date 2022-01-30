package com.example.android.dailywritingprompt.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.android.dailywritingprompt.models.Entry

@Dao
interface EntryDatabaseDao {

    @Query("SELECT * FROM writing_entry_table ORDER BY entryId DESC")
    fun getAllEntries(): LiveData<List<DatabaseEntry>>
}