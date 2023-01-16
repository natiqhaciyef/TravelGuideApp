package com.natiqhaciyef.travelguideapp.data.model

data class PostModel(
    var id: String,
    var name: String,
    var details: String,
    var rating: Double,
    var image: String,
    var isLiked: Boolean
)
