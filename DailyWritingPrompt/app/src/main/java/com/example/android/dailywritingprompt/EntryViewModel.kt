package com.example.android.dailywritingprompt

import android.app.Application
import androidx.lifecycle.*
import com.example.android.dailywritingprompt.database.DatabaseEntry
import com.example.android.dailywritingprompt.database.EntryDatabaseDao
import com.example.android.dailywritingprompt.models.Entry
import kotlinx.coroutines.launch

class EntryViewModel(val database: EntryDatabaseDao,
                     application: Application) : AndroidViewModel(application) {

    private var entry = MutableLiveData<DatabaseEntry?>()

    val entries = database.getAllEntries()

    private val _navigateToEntryDetail = MutableLiveData<Entry?>()
    val navigateToEntryDetail: MutableLiveData<Entry?>
        get() = _navigateToEntryDetail

    fun onEntryClicked(entry: Entry) {
        _navigateToEntryDetail.value = entry
    }

    fun onEntryNavigated() {
        _navigateToEntryDetail.value = null
    }

    private fun getAllEntries() {
        viewModelScope.launch {
//            entry.value =
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EntryViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return EntryViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct ViewModel")
        }
    }

}

