package cl.malditosnakamas.rickandmorty3.location.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.malditosnakamas.network.RetrofitHandler
import cl.malditosnakamas.rickandmorty3.R
import cl.malditosnakamas.rickandmorty3.location.data.remote.RemoteLocationRepository
import cl.malditosnakamas.rickandmorty3.location.domain.GetAllLocationsUseCase
import cl.malditosnakamas.rickandmorty3.location.domain.LocationRepository
import cl.malditosnakamas.rickandmorty3.location.domain.model.Location
import cl.malditosnakamas.rickandmorty3.location.domain.model.Locations
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class LocationFragment : Fragment(), LocationItemListener  {

    private lateinit var getAllLocationsUseCase: GetAllLocationsUseCase

    private lateinit var rvLocations: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        setupRecyclerView(view)
        setupUseCase()
        return view
    }

    @SuppressLint("CheckResult")
    private fun setupUseCase() {
        val repository = RemoteLocationRepository(RetrofitHandler.getLocationApi())
        getAllLocationsUseCase = GetAllLocationsUseCase(repository)
        getAllLocationsUseCase
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                handleResult(result)
            }, { error ->
                handleError(error)
            })
    }

    private fun handleResult(result: Locations) {
        rvLocations.adapter = LocationAdapter(result.list, this)
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    private fun setupRecyclerView(view: View) {
        rvLocations = view.findViewById(R.id.rvLocations)
        rvLocations.setHasFixedSize(true)
        rvLocations.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onLocationItemClick(location: Location) {
        Toast.makeText(requireContext(), location.name, Toast.LENGTH_LONG).show()
    }
}