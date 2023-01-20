package com.natiqhaciyef.travelguideapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TicketModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "airlineName") var airlineName: String,
    @ColumnInfo(name = "location") var location: String,
    @ColumnInfo(name = "destination") var destination: String,
    @ColumnInfo(name = "price") var price: String,
    @ColumnInfo(name = "depTime") var depTime: String = "",
    @ColumnInfo(name = "retTime") var retTime: String = "",
    @ColumnInfo(name = "departureDate") var departureDate: String, // gedis
    @ColumnInfo(name = "returnDate") var returnDate: String,    // gelis
    @ColumnInfo(name = "passenger") var passenger: String = "",
    @ColumnInfo(name = "passengerName") var passengersName: String = ""
): Serializable