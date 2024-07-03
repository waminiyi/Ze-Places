package com.waminiyi.zeplaces.ui.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.R
import com.waminiyi.zeplaces.ui.theme.DarkGrey
import com.waminiyi.zeplaces.ui.theme.LightGrey

@Composable
fun FilterChip(
    text: String,
    @DrawableRes iconResourceId: Int,
    selected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) MaterialTheme.colorScheme.primary else LightGrey
        ),
        onClick = onOptionSelected,
        color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary,
        contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else DarkGrey,
        modifier = modifier
    ) {
        Row(
            Modifier
                .wrapContentWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = iconResourceId),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }

}

@Composable
@Preview
fun FilterChipPreview() {
    FilterChip(
        text = "Restaurants",
        selected = false,
        iconResourceId = R.drawable.list,
        onOptionSelected = {},
    )
}

@Composable
@Preview
fun SelectedFilterChipPreview() {
    FilterChip(
        text = "Restaurants",
        selected = true,
        iconResourceId = R.drawable.list,
        onOptionSelected = {},
    )
}