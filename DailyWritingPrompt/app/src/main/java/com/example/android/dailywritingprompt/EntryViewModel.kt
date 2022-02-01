package com.example.android.dailywritingprompt

import android.app.Application
import android.os.CountDownTimer
import android.provider.Settings.Global.getString
import android.text.Editable
import android.text.TextWatcher
import android.text.format.DateUtils
import android.util.Log
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.android.dailywritingprompt.models.Entry
import kotlinx.coroutines.launch

class EntryViewModel(
//    val database: EntryDatabaseDao,
                     application: Application) : AndroidViewModel(application) {

//    private var entry = MutableLiveData<DatabaseEntry?>()

//    val entries = database.getAllEntries()

    companion object {
        // Time for when the game is over
        private const val DONE = 0L

        //TODO: we might keep this
        // This is the time when the phone will start buzzing each second
        private const val COUNTDOWN_PANIC_SECONDS = 10L

        // This is the number of milliseconds in a second
        private const val ONE_SECOND = 1000L

        //TODO: We will change this based on whats chosen in PromptFragment
        // This is the total time of the game
        private const val COUNTDOWN_TIME = 60000L

    }

    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            characterCountString.length

            // In this space is where we r supposed to change the field to reflect
            // the neww number

        }

    }

    private val timer: CountDownTimer

    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    // Convert the time into a string
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish


    /**
     * Properties for the textwatcher are here
     */
    //TODO: Let's count characters first. then when we do that successfully let's try
    // to convert it to word count using this:
    // https://stackoverflow.com/questions/55426910/how-to-count-the-number-of-words-in-kotlin-android

    private val _characterCount = MutableLiveData<Int>()
    val characterCount: LiveData<Int>
        get() = _characterCount

    val characterCountString = characterCount.toString()


    private val _entries = MutableLiveData<ArrayList<Entry>>()
    val entries: LiveData<ArrayList<Entry>>
        get() = _entries

    private val _navigateToEntryDetail = MutableLiveData<Entry?>()
    val navigateToEntryDetail: MutableLiveData<Entry?>
        get() = _navigateToEntryDetail

    init {
        //TODO: Implement timer in EntryFragment whose time is set based on spinner from PromptFragment
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / ONE_SECOND)
            }
            override fun onFinish() {
                _currentTime.value = DONE

                // False by default; set to true to initiate the navigation
                _eventGameFinish.value = true
            }
        }.start()

    }



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

    fun onWritingComplete() {
        _eventGameFinish.value = false
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

