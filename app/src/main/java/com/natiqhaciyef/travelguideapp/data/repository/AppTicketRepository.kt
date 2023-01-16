package com.natiqhaciyef.travelguideapp.data.repository

import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.source.AppDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppTicketRepository(val ds: AppDataSource) {

    suspend fun getAllTickets() = withContext(Dispatchers.IO){
        ds.getAllTickets()
    }

    suspend fun addTicket(ticket: TicketModel) = withContext(Dispatchers.IO){
        ds.addTicket(ticket)
    }

    suspend fun deleteTicket(ticket: TicketModel) = withContext(Dispatchers.IO){
        ds.deleteTicket(ticket)
    }
}