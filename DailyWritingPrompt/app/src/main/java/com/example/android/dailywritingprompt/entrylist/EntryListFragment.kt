package com.example.android.dailywritingprompt.entrylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.dailywritingprompt.EntryViewModel
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.FragmentEntryListBinding
import com.example.android.dailywritingprompt.models.Entry

/**
 * A fragment representing a list of Items.
 */

//TODO: make the list populate so u can test the hookups u did to the viewmodel
class EntryListFragment : Fragment() {

    private lateinit var binding: FragmentEntryListBinding

    private val viewModel: EntryViewModel by lazy {
        val activity = requireNotNull(this.activity) {

        }

        ViewModelProvider(
            this,
            EntryViewModel.Factory(activity.application)
        )[EntryViewModel::class.java]
    }

    private val entryAdapter = EntryRecyclerViewAdapter(EntryRecyclerViewAdapter
        .EntryListener { entry ->
            viewModel.onEntryClicked(entry)
        })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentEntryListBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.entryListViewModel = viewModel
        binding.fragmentEntryRv.adapter = entryAdapter

        viewModel.navigateToEntryDetail.observe(viewLifecycleOwner, Observer { entry ->
            if (entry != null) {
                this.findNavController().navigate(EntryListFragmentDirections
                    .actionEntryListFragmentToEntryDetailFragment(entry))
                viewModel.onEntryNavigated()
            }
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Make the entries appear in the list

        binding.addEntryButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(EntryListFragmentDirections.actionEntryListFragmentToPromptFragment())
        }
    }

}
