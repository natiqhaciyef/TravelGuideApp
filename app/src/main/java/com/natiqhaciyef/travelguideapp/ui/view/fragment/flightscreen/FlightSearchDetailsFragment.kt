package com.natiqhaciyef.travelguideapp.ui.view.fragment.flightscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.api.Distribution.BucketOptions.Linear
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.databinding.FragmentFlightSearchDetailsBinding
import com.natiqhaciyef.travelguideapp.ui.adapter.FlightAdapter
import com.natiqhaciyef.travelguideapp.ui.viewmodel.home.FlightViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlightSearchDetailsFragment : Fragment() {
    private lateinit var binding: FragmentFlightSearchDetailsBinding
    private lateinit var adapter: FlightAdapter
    private val viewModel: FlightViewModel by viewModels()
    private var list = mutableListOf<TicketModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_search_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerLiveData()
    }

    private fun observerLiveData(){
        viewModel.tickets.observe(viewLifecycleOwner){
            list = it.toMutableList()
            adapter = FlightAdapter(requireContext(), list)
            binding.recyclerTickets.adapter = adapter
            binding.recyclerTickets.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
    }
}