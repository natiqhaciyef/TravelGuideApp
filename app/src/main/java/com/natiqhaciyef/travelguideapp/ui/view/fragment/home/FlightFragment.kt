package com.natiqhaciyef.travelguideapp.ui.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.databinding.FragmentFlightBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlightFragment : Fragment() {
    private lateinit var binding: FragmentFlightBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.flightFragment = this
    }
}