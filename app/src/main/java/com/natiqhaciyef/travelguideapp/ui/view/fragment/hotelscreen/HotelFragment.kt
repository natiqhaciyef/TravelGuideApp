package com.natiqhaciyef.travelguideapp.ui.view.fragment.hotelscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.travelguideapp.R
import com.natiqhaciyef.travelguideapp.data.model.HotelModel
import com.natiqhaciyef.travelguideapp.databinding.FragmentHotelBinding
import com.natiqhaciyef.travelguideapp.ui.adapter.HotelAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding
    private lateinit var adapter: HotelAdapter
    private var list = mutableListOf(
        HotelModel(
            1,
            "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/1f/fa/52/skyline-suite-at-1-hotel.jpg?w=700&h=-1&s=1",
            "Bridge hotel",
            "120 $",
            "New York City, Brooklyn, Michael Black avenue, str 12, apartment 44",
            "7.8"
        ),
        HotelModel(
            2,
            "https://file.videopolis.com/F/1/1254ee4c-ee88-414f-b414-e50d7d4cd0fd/101752.13279.new-york.kimberly-new-york.hero-2QxwYUEo-58818-1280x720.jpeg",
            "Cambly hotel",
            "110 $",
            "New York City, Manhattan, Williams str 18, apartment 14",
            "9.1"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hotel, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hotelFragment = this

        binding.hotelSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    // filter
                }
                return false
            }
        })

        adapter = HotelAdapter(requireContext(), list)
        binding.hotelRecyclerView.adapter = adapter
        binding.hotelRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}