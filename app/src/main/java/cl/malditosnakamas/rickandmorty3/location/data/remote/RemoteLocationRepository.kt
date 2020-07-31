package cl.malditosnakamas.rickandmorty3.location.data.remote

import cl.malditosnakamas.rickandmorty3.location.domain.LocationRepository
import cl.malditosnakamas.rickandmorty3.location.domain.model.Locations
import io.reactivex.Single

class RemoteLocationRepository(
    private val locationApi: LocationApi
) : LocationRepository {

    override fun getLocations(): Single<Locations> {
        return locationApi.getLocationApi()
    }
}