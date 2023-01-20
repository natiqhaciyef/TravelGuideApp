package com.natiqhaciyef.travelguideapp.ui.view.fragment.trainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.natiqhaciyef.travelguideapp.R
import dagger.hilt.android.AndroidEntryPoint
import com.natiqhaciyef.travelguideapp.databinding.*

@AndroidEntryPoint
class TrainFragment : Fragment() {
    private lateinit var binding: FragmentTrainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_train, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.trainFragment = this

        binding.searchTrainButton.setOnClickListener {
            val location = binding.locationTextTrain.text
            val destination = binding.destinationTextTrain.text
            val passenger = binding.passengerTextTrain.text
            if (location.isNotEmpty() &&
                destination.isNotEmpty() &&
                passenger.isNotEmpty()
            )
                Navigation.findNavController(it).navigate(R.id.trainDetailsFragment)
        }
    }
}