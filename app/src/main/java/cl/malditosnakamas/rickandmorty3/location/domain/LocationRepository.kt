package cl.malditosnakamas.rickandmorty3.location.domain

import cl.malditosnakamas.rickandmorty3.location.domain.model.Locations
import io.reactivex.Single

interface LocationRepository {
    fun getLocations() : Single<Locations>
}