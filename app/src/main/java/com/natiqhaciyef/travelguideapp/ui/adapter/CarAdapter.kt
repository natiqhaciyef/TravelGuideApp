package com.natiqhaciyef.travelguideapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.CarModel
import com.natiqhaciyef.travelguideapp.databinding.RecyclerCarPostBinding
import com.natiqhaciyef.travelguideapp.ui.behavior.CarClickBehavior

class CarAdapter(val mContext: Context, val list: MutableList<CarModel>) :
    RecyclerView.Adapter<CarAdapter.CarHolder>() {

    private var listener: CarClickBehavior? = null
    inner class CarHolder(val binding: RecyclerCarPostBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val binding: RecyclerCarPostBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_car_post, parent, false)
        return CarHolder(binding)
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        val view = holder.binding
        val car = list[position]

        view.car = car
        Glide.with(mContext).load(car.image).into(view.carImageView)
        holder.itemView.setOnClickListener {
            listener?.setOnClickListener(car)
        }
    }

    fun onClickAction(listener: CarClickBehavior){
        this.listener = listener
    }

    override fun getItemCount(): Int = list.size
}