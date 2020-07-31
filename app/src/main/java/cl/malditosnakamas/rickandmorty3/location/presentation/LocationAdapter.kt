package cl.malditosnakamas.rickandmorty3.location.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.malditosnakamas.rickandmorty3.R
import cl.malditosnakamas.rickandmorty3.location.domain.model.Location

class LocationAdapter(
    private val locations: List<Location>,
    private val listener: LocationItemListener?
) : RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.location_item, parent, false)
        return LocationViewHolder(view, listener)
    }

    override fun getItemCount() = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(locations[position])
    }
}