package com.example.android.dailywritingprompt

import android.app.Application
import androidx.lifecycle.*
import com.example.android.dailywritingprompt.models.Entry

class EntryViewModel(application: Application) : AndroidViewModel(application) {

    private val _navigateToEntryDetail = MutableLiveData<Entry?>()
    val navigateToEntryDetail: MutableLiveData<Entry?>
        get() = _navigateToEntryDetail

    fun onEntryClicked(entry: Entry) {
        _navigateToEntryDetail.value = entry
    }

    fun onEntryNavigated() {
        _navigateToEntryDetail.value = null
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

