package com.example.android.dailywritingprompt.createentry

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.android.dailywritingprompt.EntryViewModel
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.EntryFragmentBinding
import com.example.android.dailywritingprompt.models.Entry

//TODO: Display some kind of warning message if the user clicks back, and if possible, the menu/home buttons
// Maybe there's a way to hide it like when a game is being played

class EntryFragment : Fragment() {

    private val viewModel by activityViewModels<EntryViewModel>()

    private lateinit var binding: EntryFragmentBinding

    private val entry = Entry()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.entry_fragment,
            container,
            false
        )

        binding.entryObject = entry

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testingButton.setOnClickListener{
            viewModel.addEntry(entry)

            view.findNavController()
                .navigate(EntryFragmentDirections.actionEntryFragmentToEntryDetailFragment(entry))
        }
    }


}