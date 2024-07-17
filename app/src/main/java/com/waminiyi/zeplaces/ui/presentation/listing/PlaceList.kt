package com.waminiyi.zeplaces.ui.presentation.listing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.data.fakePlacesOfInterest
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.ui.presentation.component.PlaceItem

@Suppress("UndocumentedPublicFunction")
@Composable
fun PlaceList(
    nearbyPlaces: List<PlaceOfInterest>,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(nearbyPlaces) { item ->
            PlaceItem(place = item)
        }
    }
}

@Suppress("UndocumentedPublicFunction")
@Preview(showBackground = true)
@Composable
fun PlaceListPreview() {
    PlaceList(fakePlacesOfInterest)
}