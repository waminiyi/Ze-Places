package com.waminiyi.zeplaces.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.waminiyi.zeplaces.data.fakePlacesOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.ui.presentation.PlacesViewModel
import com.waminiyi.zeplaces.ui.presentation.listing.ListingScreen
import com.waminiyi.zeplaces.ui.presentation.listing.ViewType
import com.waminiyi.zeplaces.ui.theme.ZePlacesTheme
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

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
                    val placeViewModel = koinViewModel<PlacesViewModel>()


                    var selectedPlaceType by remember {
                        mutableStateOf(PlaceType.RESTAURANT)
                    }
                    var viewType by remember {
                        mutableStateOf(ViewType.List)
                    }

                    val places by placeViewModel.nearbyPlaces.collectAsState(initial = emptyList())

                    ListingScreen(
                        nearbyPlaces = places,
                        viewType = viewType,
                        onViewSwitch = {
                            viewType = when (viewType) {
                                ViewType.List -> ViewType.Map
                                ViewType.Map -> ViewType.List

                            }
                        },
                        selectedPlaceType = selectedPlaceType,
                        onPlaceTypeChanged = {
                            selectedPlaceType = it
                            placeViewModel.fetchNearbyPlaces(placeType = it)
                        },
                        modifier = Modifier.padding(innerPadding)

                    )
//                        .also { Log.d("places:", placeViewModel.nearbyPlaces.toList().toString()) }

                }
            }
        }
    }
}
