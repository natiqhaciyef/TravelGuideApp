package com.natiqhaciyef.travelguideapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.timeCalculatorAM
import com.natiqhaciyef.travelguideapp.data.timesDifferencesCalculator
import com.natiqhaciyef.travelguideapp.databinding.RecyclerFlightTicketBinding

class FlightAdapter(val mContext: Context,
                    val list: MutableList<TicketModel>): RecyclerView.Adapter<FlightAdapter.FlightHolder>()  {

    inner class FlightHolder(val binding: RecyclerFlightTicketBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightHolder {
        val binding: RecyclerFlightTicketBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_flight_ticket, parent, false)
        return FlightHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightHolder, position: Int) {
        val ticket = list[position]
        val view = holder.binding

        view.ticket = ticket
        view.ticketDepTime.text = timeCalculatorAM(ticket.depTime)
        view.ticketRetTime.text = timeCalculatorAM(ticket.retTime)
        view.timeline.text = timesDifferencesCalculator(ticket.depTime, ticket.retTime)
    }

    override fun getItemCount(): Int = list.size
}