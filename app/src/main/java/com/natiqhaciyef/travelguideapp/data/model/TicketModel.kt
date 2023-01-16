package com.natiqhaciyef.travelguideapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TicketModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var airlineName: String,
    var location: String,
    var price: String,
    var departureDate: String, // gedis
    var returnDate: String,    // gelis
    var passenger: String
)