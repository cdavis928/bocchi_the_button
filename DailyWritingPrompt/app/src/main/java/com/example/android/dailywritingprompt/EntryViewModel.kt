package com.example.android.dailywritingprompt

import android.app.Application
import androidx.lifecycle.*
import com.example.android.dailywritingprompt.models.Entry
import kotlinx.coroutines.launch

class EntryViewModel(
//    val database: EntryDatabaseDao,
                     application: Application) : AndroidViewModel(application) {

//    private var entry = MutableLiveData<DatabaseEntry?>()

//    val entries = database.getAllEntries()
    private val _entries = MutableLiveData<ArrayList<Entry>>()
    val entries: LiveData<ArrayList<Entry>>
        get() = _entries

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

    fun addEntry(entry: Entry) {
        _entries.value?.add(entry)
        println(entry.entryContent)
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

