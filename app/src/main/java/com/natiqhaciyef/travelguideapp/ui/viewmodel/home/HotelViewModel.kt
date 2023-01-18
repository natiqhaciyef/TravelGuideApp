package com.natiqhaciyef.travelguideapp.ui.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.natiqhaciyef.travelguideapp.data.model.HotelModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor() : ViewModel(){
    val hotels = MutableLiveData<List<HotelModel>>()

    init {
        getHotelsFromFirebase()
    }

    fun getHotelsFromFirebase(){
        val firestore = Firebase.firestore
        val list = mutableListOf<HotelModel>()
        viewModelScope.launch(Dispatchers.Main) {
            firestore.collection("Hotels").addSnapshotListener{value, error ->
                if (value != null){
                    val docs = value.documents
                    list.clear()
                    for (doc in docs){
                        val id = doc.get("id") as Int
                        val name = doc.get("hotelName") as String
                        val dailyPrice = doc.get("dailyPrice") as String
                        val location = doc.get("location") as String
                        val rating = doc.get("rating") as String

                        val hotel = HotelModel(id, name, dailyPrice, location, rating)
                        list.add(hotel)
                    }
                    hotels.value = list
                }
            }
        }
    }
}

