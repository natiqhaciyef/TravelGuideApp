package com.natiqhaciyef.travelguideapp.ui.behavior

import com.natiqhaciyef.travelguideapp.data.model.CarModel

interface CarClickBehavior {
    fun setOnClickListener(car: CarModel)
}