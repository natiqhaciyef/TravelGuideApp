package com.natiqhaciyef.travelguideapp.ui.view.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.PostModel
import com.natiqhaciyef.travelguideapp.databinding.FragmentHomeBinding
import com.natiqhaciyef.travelguideapp.ui.adapter.HomePostAdapter
import java.util.UUID

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: HomePostAdapter
    private val list = mutableListOf(
        PostModel(UUID.randomUUID().toString(), "Switzerland","Bern",4.5,"photo_switzerland",false),
        PostModel(UUID.randomUUID().toString(), "China","Macao",4.5,"photo_china",false),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        adapter = HomePostAdapter(list, requireContext())
        binding.adapter = adapter
        binding.homePostsRecyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        binding.flightCardView.setOnClickListener { flightSelected(it) }
        binding.flightItemHome.setOnClickListener { flightSelected(it) }

        binding.hotelCardView.setOnClickListener { hotelSelected(it) }
        binding.hotelItemHome.setOnClickListener { hotelSelected(it) }

        binding.carCardView.setOnClickListener { carSelected(it) }
        binding.carItemHome.setOnClickListener { carSelected(it) }

        binding.trainCardView.setOnClickListener { trainSelected(it) }
        binding.trainItemHome.setOnClickListener { trainSelected(it) }


    }

    private fun flightSelected(view: View){
        Navigation.findNavController(view).navigate(R.id.flightFragment)
    }

    private fun hotelSelected(view: View){
        Navigation.findNavController(view).navigate(R.id.hotelFragment)
    }

    private fun carSelected(view: View){
        Navigation.findNavController(view).navigate(R.id.carFragment)
    }

    private fun trainSelected(view: View){
        Navigation.findNavController(view).navigate(R.id.trainFragment)
    }
}