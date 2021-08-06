package com.example.rent_a_boat.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rent_a_boat.HomeFragmentDirections
import com.example.rent_a_boat.R
import com.example.rent_a_boat.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.feedRecyclerview
        recyclerView.adapter = BoatsAdapter(BOATS, ::onBoatClick)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun onBoatClick(boatId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToBoatFragment(boatId)
        requireActivity().findNavController(R.id.nav_ContainerView).navigate(action)
    }
}