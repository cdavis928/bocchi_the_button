package com.example.android.dailywritingprompt.createentry

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.dailywritingprompt.EntryViewModel
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.EntryFragmentBinding
import com.example.android.dailywritingprompt.models.Entry

//TODO: Display some kind of warning message if the user clicks back, and if possible, the menu/home buttons
// Maybe there's a way to hide it like when a game is being played

class EntryFragment : Fragment() {

    private lateinit var viewModel: EntryViewModel

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

        viewModel = ViewModelProvider(this)[EntryViewModel::class.java]

        // Important: The app can run without this but you will not be populating any of the
        // fields that require the use of the viewModel. So don't forget to bind the viewmodel!
        binding.entryViewModel = viewModel

        binding.entryObject = entry

        binding.lifecycleOwner = this


        // Set up event listening to take player to PromptFragment when timer is done
        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { isFinished ->
            if (isFinished) {
                val action = EntryFragmentDirections.actionEntryFragmentToEntryDetailFragment(entry)
                findNavController().navigate(action)
                viewModel.onWritingComplete()
            }
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: Remove after testing
        binding.testingButton.setOnClickListener{
            viewModel.addEntry(entry)
            view.findNavController()
                .navigate(EntryFragmentDirections.actionEntryFragmentToEntryDetailFragment(entry))
        }
    }

}