package cl.malditosnakamas.rickandmorty3.location.domain

class GetAllLocationsUseCase(
    private val repository: LocationRepository
) {
    fun execute() = repository.getLocations()
}