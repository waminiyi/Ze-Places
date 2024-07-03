package com.waminiyi.zeplaces.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.waminiyi.zeplaces.data.fakePlacesOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.ui.presentation.listing.ListingScreen
import com.waminiyi.zeplaces.ui.presentation.listing.ViewType
import com.waminiyi.zeplaces.ui.theme.ZePlacesTheme
import org.koin.android.ext.android.inject

/**
 * The main activity of the Ze'Mates app.
 */
class MainActivity : ComponentActivity() {
    private val placeRepository: PlacesRepository by inject()

    @Suppress("MagicNumber")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZePlacesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//                    var nearbyPlaces by remember { mutableStateOf(emptyList<PlaceOfInterest>()) }
//                    LaunchedEffect(Unit) {
//                        nearbyPlaces = placeRepository.getNearbyPlaces(
//                            coordinates = Coordinates(
//                                -33.8670522,
//                                151.1957362
//                            ),
//                            radius = 1500,
//                            placeType = PlaceType.RESTAURANT
//                        )
//                    }
                    var selectedPlaceType by remember {
                        mutableStateOf(PlaceType.RESTAURANT)
                    }
                    var viewType by remember {
                        mutableStateOf(ViewType.List)
                    }

                    ListingScreen(
                        nearbyPlaces = fakePlacesOfInterest,
                        viewType = viewType,
                        onViewSwitch = {
                            viewType = when (viewType) {
                                ViewType.List -> ViewType.Map
                                ViewType.Map -> ViewType.List

                            }
                        },
                        selectedPlaceType = selectedPlaceType,
                        onPlaceTypeChanged = { selectedPlaceType = it },
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }
        }
    }
}
