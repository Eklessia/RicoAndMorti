package cl.malditosnakamas.rickandmorty3.location.presentation

import cl.malditosnakamas.rickandmorty3.location.domain.model.Location

interface LocationItemListener {
    fun onLocationItemClick(location: Location)
}