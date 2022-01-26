package com.example.android.dailywritingprompt.entrylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.dailywritingprompt.R
import com.example.android.dailywritingprompt.databinding.FragmentEntryListBinding
import com.example.android.dailywritingprompt.models.Entry
import com.example.android.dailywritingprompt.models.EntryItem

/**
 * A fragment representing a list of Items.
 */
class EntryListFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentEntryListBinding.inflate(inflater)

        binding.fragmentEntryRv.adapter = EntryRecyclerViewAdapter(Entry.ITEMS)

        return binding.root

    }




    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            EntryListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}