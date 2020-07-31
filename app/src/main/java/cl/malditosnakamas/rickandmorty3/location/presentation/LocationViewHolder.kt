package cl.malditosnakamas.rickandmorty3.location.presentation

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import cl.malditosnakamas.rickandmorty3.R
import cl.malditosnakamas.rickandmorty3.location.domain.model.Location

class LocationViewHolder(view: View, private val locationListener: LocationItemListener?) :
    RecyclerView.ViewHolder(view) {

    private val tvIdLocation = view.findViewById<TextView>(R.id.tvIdLocation)
    private val tvNameLocation = view.findViewById<TextView>(R.id.tvNameLocation)
    private val tvTypeLocation = view.findViewById<TextView>(R.id.tvTypeLocation)
    private val tvDimensionLocation = view.findViewById<TextView>(R.id.tvDimensionLocation)
    private val cvItemLocation = view.findViewById<CardView>(R.id.cvItemLocation)


    fun bind(location: Location) {
        tvIdLocation.text = location.id.toString()
        tvNameLocation.text = location.name
        tvTypeLocation.text = location.type
        tvDimensionLocation.text = location.dimension
        cvItemLocation.setOnClickListener { locationListener?.onLocationItemClick(location) }
    }
}