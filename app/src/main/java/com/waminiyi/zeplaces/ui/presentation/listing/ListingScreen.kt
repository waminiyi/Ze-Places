package com.waminiyi.zeplaces.ui.presentation.listing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.R
import com.waminiyi.zeplaces.data.fakePlacesOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceType
import com.waminiyi.zeplaces.ui.presentation.component.ListingView
import com.waminiyi.zeplaces.ui.presentation.component.PlacesFilters
import com.waminiyi.zeplaces.ui.presentation.component.SearchBar

@Composable
fun ListingScreen(
    nearbyPlaces: List<PlaceOfInterest>,
    viewType: ViewType,
    onViewSwitch: () -> Unit,
    selectedPlaceType: PlaceType,
    onPlaceTypeChanged: (PlaceType) -> Unit,
    modifier: Modifier = Modifier
) {

    Column {
        Spacer(Modifier.height(48.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))


        PlacesFilters(
            list = PlaceType.entries,
            selectedType = selectedPlaceType,
            onOptionSelected = { onPlaceTypeChanged(it) },
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            when (viewType) {
                ViewType.List -> {
                    PlaceList(
                        nearbyPlaces = nearbyPlaces,
                        modifier = Modifier.padding(8.dp)
                    )
                    ListingView(
                        text = stringResource(id = R.string.show_map),
                        icon = R.drawable.list,
                        onClick = { onViewSwitch() },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 24.dp, bottom = 24.dp)
                    )
                }

                ViewType.Map -> {
                    Text(text = "Map view coming soon")

                    ListingView(
                        text = stringResource(id = R.string.show_list),
                        icon = R.drawable.list,
                        onClick = { onViewSwitch() },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 24.dp, bottom = 24.dp)
                    )
                }
            }

        }
        Spacer(Modifier.height(48.dp))
    }
}

@Preview
@Composable
fun ListingScreenPreview() {
    ListingScreen(
        nearbyPlaces = fakePlacesOfInterest,
        viewType = ViewType.List,
        onViewSwitch = {},
        selectedPlaceType = PlaceType.RESTAURANT,
        onPlaceTypeChanged = {},
    )
}