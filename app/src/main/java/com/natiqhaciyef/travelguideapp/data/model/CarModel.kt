package com.natiqhaciyef.travelguideapp.data.model

import java.io.Serializable

data class CarModel(
    var id: Int,
    var image: String,
    var brand: String,
    var model: String,
    var description: String,
    var engine: String,
    var fuelCapacity: String,
    var transmission: String,
    var color: String,
    var date: String,
    var country: String,
    var price: String,
    var drive: String
): Serializable