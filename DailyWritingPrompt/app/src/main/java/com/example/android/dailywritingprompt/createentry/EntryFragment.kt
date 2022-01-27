package com.example.android.dailywritingprompt.createentry

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.EntryFragmentBinding

//TODO: Display some kind of warning message if the user clicks back, and if possible, the menu/home buttons
// Maybe there's a way to hide it like when a game is being played

class EntryFragment : Fragment() {

    private lateinit var binding: EntryFragmentBinding

    companion object {
        fun newInstance() = EntryFragment()
    }

    private lateinit var viewModel: EntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.entry_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
        // TODO: Use the ViewModel
    }



}