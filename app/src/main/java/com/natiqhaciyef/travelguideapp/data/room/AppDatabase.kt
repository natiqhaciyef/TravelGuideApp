package com.natiqhaciyef.travelguideapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.natiqhaciyef.travelguideapp.data.model.TicketModel
import com.natiqhaciyef.travelguideapp.data.model.User

@Database(entities = [User::class, TicketModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): AppDao
}