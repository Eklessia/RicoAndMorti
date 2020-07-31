package cl.malditosnakamas.rickandmorty3.location.data.remote

import cl.malditosnakamas.rickandmorty3.location.domain.model.Locations
import io.reactivex.Single
import retrofit2.http.GET

interface LocationApi {

    @GET("location")
    fun getLocationApi() : Single<Locations>
}