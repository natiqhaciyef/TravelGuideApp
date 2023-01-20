package com.natiqhaciyef.travelguideapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.TrainModel
import com.natiqhaciyef.travelguideapp.data.toCustomList
import com.natiqhaciyef.travelguideapp.databinding.RecyclerTrainPostBinding

class TrainAdapter(val mContext: Context, val list: MutableList<TrainModel>)
    : RecyclerView.Adapter<TrainAdapter.TrainHolder>() {

    inner class TrainHolder(val binding: RecyclerTrainPostBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainHolder {
        val binding: RecyclerTrainPostBinding = DataBindingUtil
            .inflate(LayoutInflater.from(mContext), R.layout.recycler_train_post, parent, false)
        return TrainHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainHolder, position: Int) {
        val view = holder.binding
        val train = list[position]

        view.train = train
        val stationNumber = train.stations.toCustomList().size
        view.stationNumber.text = if (stationNumber > 1) "$stationNumber stations" else "$stationNumber station"
     }

    override fun getItemCount(): Int = list.size
}