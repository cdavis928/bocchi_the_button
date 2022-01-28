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

        return binding.root
    }


}