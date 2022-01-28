package com.example.android.dailywritingprompt.models

import android.os.Parcelable
import java.util.ArrayList
import java.util.HashMap
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Entry(
    //TODO: I changed some of these to string because i assume it'll be better
    // for me to parse them into strings for the sake of better readability in the UI.
    // If this is wrong though, change them back to Int, Float, respectively
    val entryTitle: String,
    val entryPreview: String,
    val wordCount: String,
    val writeTime: String,
    val entryId: Int
) : Parcelable