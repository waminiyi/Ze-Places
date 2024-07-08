package com.waminiyi.zeplaces.ui.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.waminiyi.zeplaces.ui.theme.Yellow
import com.waminiyi.zeplaces.ui.utils.RatingBar

/**
 * A composable function that displays a place rating with a rating bar and count of ratings.
 *
 * @param modifier The Modifier to be applied to the PlaceRating composable.
 * @param rating The current rating to be displayed. Can be null.
 * @param ratingCount The number of ratings to be displayed. Can be null.
 */
@Composable
fun PlaceRating(
    modifier: Modifier = Modifier,
    rating: Float?,
    ratingCount: Int?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        rating?.let {
            Text(text = it.toString())
            RatingBar(
                rating = it,
                emptyColor = Color.Gray,
                fillColor = Yellow,
                starSize = 18.dp,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 4.dp)
            )
        }
        ratingCount?.let {
            Text(text = "($it)")
        }
    }
}

@Suppress("UndocumentedPublicFunction")
@Preview
@Composable
fun PlaceRatingPreview() {
    PlaceRating(rating = 4.4f, ratingCount = 123)
}
