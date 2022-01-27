package com.example.android.dailywritingprompt.createentry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.PromptFragmentBinding

class PromptFragment : Fragment() {

    private lateinit var binding: PromptFragmentBinding

    companion object {
        fun newInstance() = EntryFragment()
    }

    private lateinit var viewModel: EntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.prompt_fragment,
            container,
            false
        )

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EntryViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Create the logic for the minutes spinner
        val spinner: Spinner = binding.minutesSpinner

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.minutes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }


        // Clicking navigates to the entry creation screen and the timer will begin
        binding.promptButton.setOnClickListener {
            this.findNavController()
                .navigate(PromptFragmentDirections.actionPromptFragmentToEntryFragment())
        }

    }
}