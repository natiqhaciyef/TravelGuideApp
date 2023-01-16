package com.natiqhaciyef.travelguideapp.data.room

import androidx.room.*
import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.model.User

@Dao
interface AppDao {

    @Insert
    suspend fun addTicket(ticket: TicketModel)

    @Delete
    suspend fun deleteTicket(ticket: TicketModel)

    @Query("SELECT * FROM TicketModel")
    suspend fun getAllTickets(): List<TicketModel>


    @Insert
    suspend fun addUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM User WHERE email = :email")
    suspend fun getUserByEmail(email: String): User
}