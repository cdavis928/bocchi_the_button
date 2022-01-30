package com.example.android.dailywritingprompt.entrydetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.dailywritingprompt.EntryViewModel
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.EntryDetailFragmentBinding

class EntryDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = EntryDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val entry = EntryDetailFragmentArgs.fromBundle(requireArguments()).selectedEntry

        //TODO: setup more bindings like this for the other attributes that will be carried over
        // But the logic for those will need to be written first, so let's get that first.
        // In general let's get this flow of adding entry, selecting values, and then bringing
        // it to this screen BEFORE we worry about populating the recycler view + database things
        binding.entryObject = entry

        return binding.root
    }


}