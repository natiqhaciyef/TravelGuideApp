package com.natiqhaciyef.travelguideapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.HotelModel
import com.natiqhaciyef.travelguideapp.databinding.RecyclerHotelPostBinding

class HotelAdapter(val mContext: Context, val list: MutableList<HotelModel>) :
    RecyclerView.Adapter<HotelAdapter.HotelHolder>() {

    inner class HotelHolder(val binding: RecyclerHotelPostBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelHolder {
        val binding: RecyclerHotelPostBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_hotel_post, parent, false)
        return HotelHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelHolder, position: Int) {
        val hotel = list[position]
        val view = holder.binding
        view.hotel = hotel
        Glide.with(mContext).load(hotel.image).into(view.hotelImageView)
    }

    override fun getItemCount(): Int = list.size
}