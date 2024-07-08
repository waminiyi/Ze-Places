package com.waminiyi.zeplaces.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class PlacesViewModel(
    private val placeRepository: PlacesRepository
) : ViewModel() {

    private var _nearbyPlaces = MutableStateFlow<List<PlaceOfInterest>?>(null)

    val nearbyPlaces: Flow<List<PlaceOfInterest>>
        get() = _nearbyPlaces.filterNotNull()

    init {
        fetchNearbyPlaces()
    }

    fun fetchNearbyPlaces(
        placeType: PlaceType = PlaceType.RESTAURANT,
        coordinates: Coordinates = Coordinates(
            -33.8670522,
            151.1957362
        ),
        radius: Int = 1500
    ) {
        viewModelScope.launch {
            _nearbyPlaces.value = placeRepository.getNearbyPlaces(
                coordinates = coordinates,
                radius = radius,
                placeType = placeType
            )

        }
    }
}