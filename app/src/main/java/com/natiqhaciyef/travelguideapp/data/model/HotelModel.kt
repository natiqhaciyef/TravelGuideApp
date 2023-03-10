package com.natiqhaciyef.travelguideapp.data.model

import java.io.Serializable

data class HotelModel(
    var id: Int,
    var image: String,
    var hotelName: String,
    var dailyPrice: String,
    var location: String,
    var rating: String
): Serializable
