package cl.malditosnakamas.rickandmorty3.location.domain.model

import com.google.gson.annotations.SerializedName

data class Locations(
    @SerializedName("results")
    val list: List<Location>
)