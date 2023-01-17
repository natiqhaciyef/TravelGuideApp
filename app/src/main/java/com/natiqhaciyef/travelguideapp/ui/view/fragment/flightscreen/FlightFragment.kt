package com.natiqhaciyef.travelguideapp.ui.view.fragment.flightscreen

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.databinding.FragmentFlightBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_flight.*
import java.text.SimpleDateFormat
import java.util.*

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

        binding.departureDateTextFlight.setOnClickListener {
            val calendar = Calendar.getInstance()
            departureCalendar(calendar)
        }

        binding.returnDateTextFlight.setOnClickListener {
            val calendar = Calendar.getInstance()
            returnCalendar(calendar)
        }
    }


    private fun departureCalendar(calendar: Calendar){
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            binding.departureDateTextFlight.text = changeCalendar(calendar)
        }

        binding.departureDateTextFlight.setOnClickListener {
            DatePickerDialog(requireActivity(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun returnCalendar(calendar: Calendar){
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            binding.returnDateTextFlight.text = changeCalendar(calendar)
        }

        binding.returnDateTextFlight.setOnClickListener {
            DatePickerDialog(requireActivity(),
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
}