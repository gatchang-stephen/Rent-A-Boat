package com.example.rent_a_boat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rent_a_boat.databinding.FragmentBoatBinding
import com.example.rent_a_boat.feed.BOATS
import com.example.rent_a_boat.feed.getBoat

class BoatFragment : Fragment() {
    private var _binding: FragmentBoatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getString("id_dl")?.toInt() ?: arguments?.let { BoatFragmentArgs.fromBundle(it).id }
        val boat = id?.let { BOATS.getBoat(it) }
        if (boat != null) {
            binding.nameTextView.text = boat.name
            binding.locationTextView.text = boat.location
            binding.imageView2.setImageResource(boat.picture)
            binding.priceTextView.text = boat.price
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}