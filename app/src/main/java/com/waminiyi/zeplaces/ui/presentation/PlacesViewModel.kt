package com.waminiyi.zeplaces.ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.ui.utils.LocationTracker
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class PlacesViewModel(
    private val placeRepository: PlacesRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private var _nearbyPlaces = MutableStateFlow<List<PlaceOfInterest>?>(null)
     var currentLocation by mutableStateOf<Coordinates>(Coordinates(0.0, 0.0))


    val nearbyPlaces: Flow<List<PlaceOfInterest>>
        get() = _nearbyPlaces.filterNotNull()

    init {
        viewModelScope.launch() {
            val location = locationTracker.getCurrentLocation() // Location
            currentLocation = Coordinates(
                location?.latitude,
                location?.longitude
            )

        }
        fetchNearbyPlaces()
    }

    fun fetchNearbyPlaces(
        placeType: PlaceType = PlaceType.RESTAURANT,
        coordinates: Coordinates = currentLocation,
        radius: Int = 1500
    ) {
        viewModelScope.launch {
            val location = locationTracker.getCurrentLocation() // Location
            currentLocation = Coordinates(
                location?.latitude,
                location?.longitude
            )
            _nearbyPlaces.value = placeRepository.getNearbyPlaces(
                coordinates = currentLocation,
                radius = radius,
                placeType = placeType
            )

        }
    }
}