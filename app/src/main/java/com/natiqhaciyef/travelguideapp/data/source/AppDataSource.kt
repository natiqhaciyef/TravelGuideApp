package com.natiqhaciyef.travelguideapp.data.source

import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.model.User
import com.natiqhaciyef.travelguideapp.data.room.AppDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppDataSource(val dao: AppDao) {

    suspend fun getAllTickets() = withContext(Dispatchers.IO){
        dao.getAllTickets()
    }

    suspend fun addTicket(ticket: TicketModel) = withContext(Dispatchers.IO){
        dao.addTicket(ticket)
    }

    suspend fun deleteTicket(ticket: TicketModel) = withContext(Dispatchers.IO){
        dao.deleteTicket(ticket)
    }


    suspend fun addUser(user: User) = withContext(Dispatchers.IO){
        dao.addUser(user)
    }

    suspend fun getUserByEmail(email: String) = withContext(Dispatchers.IO){
        dao.getUserByEmail(email)
    }

    suspend fun deleteUser(user: User) = withContext(Dispatchers.IO){
        dao.deleteUser(user)
    }

    suspend fun updateUser(user: User) = withContext(Dispatchers.IO){
        dao.updateUser(user)
    }
}