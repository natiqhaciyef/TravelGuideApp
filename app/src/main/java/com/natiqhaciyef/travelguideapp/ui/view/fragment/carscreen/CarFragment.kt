package com.natiqhaciyef.travelguideapp.ui.view.fragment.carscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.CarModel
import com.natiqhaciyef.travelguideapp.databinding.FragmentCarBinding
import com.natiqhaciyef.travelguideapp.ui.adapter.CarAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarFragment : Fragment() {
    private lateinit var binding: FragmentCarBinding
    private lateinit var adapter: CarAdapter
    private val list = mutableListOf<CarModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_car, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.carFragment = this

        binding.carSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    // filter
                }
                return false
            }
        })

        adapter = CarAdapter(requireContext(), list)
        binding.carRecyclerView.adapter = adapter
        binding.carRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}