package com.natiqhaciyef.travelguideapp.ui.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    val usedTickets = MutableLiveData<List<TicketModel>>()
    val tickets = MutableLiveData<List<TicketModel>>()

    init {
        getAllTicketsFromRoom()
    }

    fun addTicket(ticket: TicketModel){
        viewModelScope.launch(Dispatchers.Main) {
            ticketRepo.addTicket(ticket)
        }
    }

    fun deleteTicket(ticket: TicketModel){
        viewModelScope.launch(Dispatchers.Main) {
            ticketRepo.deleteTicket(ticket)
            getAllTicketsFromRoom()
        }
    }

    private fun getAllTicketsFromRoom(){
        viewModelScope.launch(Dispatchers.Main) {
            usedTickets.value = ticketRepo.getAllTickets()
        }
    }

    fun getTicketsFromFirebase(){
        val list = mutableListOf<TicketModel>()
        val firestore = Firebase.firestore
        viewModelScope.launch(Dispatchers.Main) {
            firestore.collection("Tickets").addSnapshotListener{ value, error ->
                if (value != null){
                    val docs = value.documents
                    list.clear()
                    for (doc in docs){
                        val id = doc.get("id") as Int
                        val airlineName = doc.get("airlineName") as String
                        val location = doc.get("location") as String
                        val destination = doc.get("destination") as String
                        val price = doc.get("price") as String
                        val depTime = doc.get("depTime") as String
                        val retTime = doc.get("retTime") as String
                        val timeline = doc.get("timeline") as String
                        val departureDate = doc.get("departureDate") as String
                        val returnDate = doc.get("returnDate") as String
                        val passenger = doc.get("passenger") as String
                        val passengerName = doc.get("passengerName") as String

                        val ticket = TicketModel(
                            id, airlineName, location, destination, price, depTime, retTime,
                            timeline, departureDate, returnDate, passenger, passengerName
                        )
                        list.add(ticket)
                    }
                    tickets.value = list
                }

            }
        }
    }
}