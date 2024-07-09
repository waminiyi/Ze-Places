package com.waminiyi.zeplaces.ui.presentation.listing

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.ui.presentation.component.PlaceItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Suppress("UndocumentedPublicFunction")
@Composable
fun PlaceMap(
    coordinates: Coordinates,
    nearbyPlaces: List<PlaceOfInterest>,
    modifier: Modifier = Modifier
) {

    val currentLocation = LatLng(coordinates.latitude ?: 0.0, coordinates.longitude ?: 0.0)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(currentLocation, 15f)
    }

    val sheetState = rememberModalBottomSheetState()
    val (selectedPlace, setSelectedPlace) = remember { mutableStateOf<PlaceOfInterest?>(null) }


    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            nearbyPlaces.forEach { place ->
                AdvancedMarker(
                    state = MarkerState(
                        position = LatLng(
                            place.address.coordinates?.latitude ?: 0.0,
                            place.address.coordinates?.longitude ?: 0.0
                        )
                    ),
                    onClick = {
                        setSelectedPlace(place)
                        true
                    }
                )
            }
        }

        selectedPlace?.let {
            ModalBottomSheet(
                onDismissRequest = {
                    setSelectedPlace(null)
                },
                sheetState = sheetState
            ) {
                PlaceItem(place = selectedPlace)
            }
        }

    }
}
