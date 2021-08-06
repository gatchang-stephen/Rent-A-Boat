package com.example.rent_a_boat.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rent_a_boat.R

class BoatsAdapter(
    private val boats: List<Boat>,
    private val onBoatClick: (Int) -> Unit
) : RecyclerView.Adapter<BoatsAdapter.BoatsViewHolder>() {
    inner class BoatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        private val locationTextView = itemView.findViewById<TextView>(R.id.locationTextView)
        private val imageView = itemView.findViewById<ImageView>(R.id.imageView2)
        private val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)

        fun bind(boat: Boat, onBoatClick: (Int) -> Unit) {
            nameTextView.text = boat.name
            locationTextView.text = boat.location
            imageView.setImageResource(boat.picture)
            priceTextView.text = boat.price
            itemView.setOnClickListener { onBoatClick(boat.id) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoatsViewHolder {
        return BoatsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.boat_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BoatsViewHolder, position: Int) {
        holder.bind(boats[position], onBoatClick)
    }

    override fun getItemCount(): Int = boats.size
}