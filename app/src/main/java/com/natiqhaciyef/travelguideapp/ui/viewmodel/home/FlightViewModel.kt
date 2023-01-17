package com.natiqhaciyef.travelguideapp.ui.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.repository.AppTicketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlightViewModel @Inject constructor(
    val ticketRepo: AppTicketRepository
) : ViewModel(){
    val tickets = MutableLiveData<List<TicketModel>>()

    init {
        getAllTickets()
    }

    fun addTicket(ticket: TicketModel){
        viewModelScope.launch(Dispatchers.Main) {
            ticketRepo.addTicket(ticket)
        }
    }

    fun deleteTicket(ticket: TicketModel){
        viewModelScope.launch(Dispatchers.Main) {
            ticketRepo.deleteTicket(ticket)
        }
    }

    fun getAllTickets(){
        viewModelScope.launch(Dispatchers.Main) {
            tickets.value = ticketRepo.getAllTickets()
        }
    }
}