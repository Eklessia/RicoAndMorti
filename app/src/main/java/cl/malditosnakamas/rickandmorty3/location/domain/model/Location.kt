package cl.malditosnakamas.rickandmorty3.location.domain.model

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)