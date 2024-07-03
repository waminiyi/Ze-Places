package com.waminiyi.zeplaces.ui.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.R
import com.waminiyi.zeplaces.domain.model.PlaceType

@Composable
fun PlacesFilters(
    list: List<PlaceType>,
    selectedType: PlaceType?,
    onOptionSelected: (PlaceType) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(
            items = list,
            key = { placeType -> placeType.name }
        ) { placeType ->
            val selected = placeType == selectedType

            FilterChip(
                text = placeType.value,
                selected = selected,
                iconResourceId = placeType.iconResourceId,
                onOptionSelected = { onOptionSelected(placeType) },
            )
        }
    }
}

@Composable
@Preview
fun PlacesFiltersPreview() {
    var selectedType by remember { mutableStateOf<PlaceType?>(null) }

    PlacesFilters(
        list = PlaceType.entries,
        selectedType = selectedType,
        onOptionSelected = { selectedType = it },
    )
}
