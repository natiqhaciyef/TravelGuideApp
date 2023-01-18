package com.natiqhaciyef.travelguideapp.ui.view.fragment.flightscreen

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.databinding.FragmentFlightBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_flight.*
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class FlightFragment : Fragment() {
    private lateinit var binding: FragmentFlightBinding
    private var oneWatSelected = true

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

        binding.departureDateTextFlight.setOnClickListener {
            val calendar = Calendar.getInstance()
            departureCalendar(calendar)
        }

        binding.returnDateTextFlight.setOnClickListener {
            val calendar = Calendar.getInstance()
            returnCalendar(calendar)
        }

        binding.searchFlightButton.setOnClickListener {
            if (
                binding.locationTextFlight.text.isNotEmpty() &&
                binding.destinationTextFlight.text.isNotEmpty() &&
                binding.departureDateTextFlight.text.isNotEmpty() &&
                binding.returnDateTextFlight.text.isNotEmpty() &&
                binding.passengerTextFlight.text.isNotEmpty()
            )
                Navigation.findNavController(it).navigate(R.id.flightSearchDetailsFragment)
        }

        binding.oneWayButton.setOnClickListener {
            oneWayApplying()
        }

        binding.oneWayIcon.setOnClickListener {
            oneWayApplying()
        }

        binding.reverseTripButton.setOnClickListener {
            reverseTrip()
        }

        binding.reverseIcon.setOnClickListener {
            reverseTrip()
        }
    }


    private fun departureCalendar(calendar: Calendar) {
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            binding.departureDateTextFlight.text = changeCalendar(calendar)
        }

        binding.departureDateTextFlight.setOnClickListener {
            DatePickerDialog(
                requireActivity(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun returnCalendar(calendar: Calendar) {
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            binding.returnDateTextFlight.text = changeCalendar(calendar)
        }

        binding.returnDateTextFlight.setOnClickListener {
            DatePickerDialog(
                requireActivity(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun changeCalendar(calendar: Calendar): String {
        val format = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        return sdf.format(calendar.time)
    }

    private fun oneWayApplying() {
        if (oneWatSelected) {
            binding.returnTitle.visibility = View.GONE
            binding.returnDateTextFlight.visibility = View.GONE
            binding.oneWayButton.text = "        Two way"
            binding.oneWayIcon.setImageResource(R.drawable.two_way_icon)
            oneWatSelected = !oneWatSelected
        } else {
            binding.returnTitle.visibility = View.VISIBLE
            binding.returnDateTextFlight.visibility = View.VISIBLE
            binding.oneWayButton.text = "        One way"
            binding.oneWayIcon.setImageResource(R.drawable.right_arrow_icon)
            oneWatSelected = !oneWatSelected
        }
    }

    private fun reverseTrip() {
        val location = binding.locationTextFlight.text
        val destination = binding.destinationTextFlight.text
        binding.destinationTextFlight.text = location
        binding.locationTextFlight.text = destination
    }
}