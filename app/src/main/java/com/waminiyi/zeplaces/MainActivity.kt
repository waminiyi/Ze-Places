package com.waminiyi.zeplaces

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.domain.repositories.PlacesRepository
import com.waminiyi.zeplaces.ui.theme.ZePlacesTheme
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

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

                    var nearbyPlaces by remember { mutableStateOf(emptyList<PlaceOfInterest>()) }
                    LaunchedEffect(Unit) {
                        nearbyPlaces = placeRepository.getNearbyPlaces(
                            coordinates = Coordinates(
                                -33.8670522,
                                151.1957362
                            ),
                            radius = 1500,
                            placeType = PlaceType.RESTAURANT
                        )
                    }
                    Greeting(
                        nearbyPlaces = nearbyPlaces,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Suppress("UndocumentedPublicFunction")
@Composable
fun Greeting(nearbyPlaces: List<PlaceOfInterest>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column (modifier = Modifier.verticalScroll(scrollState).padding(16.dp)) {
        Text(
            text = nearbyPlaces.toString(),
            modifier = modifier
        )
    }
}

@Suppress("UndocumentedPublicFunction")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZePlacesTheme {
        Greeting(emptyList())
    }
}
