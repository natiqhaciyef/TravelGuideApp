package com.natiqhaciyef.travelguideapp.data.model

import java.io.Serializable

data class TrainModel(
    var id: Int,
    var railwayName: String,
    var stations: String,
    var price: String,
    var location: String,
    var destination: String,
    var passenger: String,
): Serializable
