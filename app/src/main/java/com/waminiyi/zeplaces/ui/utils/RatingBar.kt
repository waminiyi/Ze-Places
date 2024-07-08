package com.waminiyi.zeplaces.ui.utils

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 * A composable function that displays a customizable rating bar.
 *
 * @param modifier The Modifier to be applied to the RatingBar.
 * @param rating The current rating to be displayed, should be a float value between 0 and totalStars.
 * @param totalStars The total number of stars to be displayed. Default is 5.
 * @param starSize The size of each star. Default is 24.dp.
 * @param spacing The spacing between each star. Default is 4.dp.
 * @param emptyColor The color of the empty (unfilled) stars.
 * @param fillColor The color of the filled stars.
 */
@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    totalStars: Int = 5,
    starSize: Dp = 24.dp,
    spacing: Dp = 4.dp,
    emptyColor: Color,
    fillColor: Color
) {
    Row(
        modifier = modifier
    ) {
        for (i in 0 until totalStars) {
            Box(modifier = Modifier.padding(horizontal = spacing / 2)) {
                Canvas(modifier = Modifier.size(starSize)) {
                    val fillPercentage = when {
                        rating > i + 1 -> 1f
                        rating > i -> rating - i
                        else -> 0f
                    }

                    drawRatingStar(fillPercentage, emptyColor, fillColor)

                }
            }
        }
    }
}

private fun createStarPath(radius: Float, center: Offset): Path {
    val path = Path()
    val angle = 72.0
    val halfAngle = angle / 2

    for (i in 0 until 5) {
        val theta = Math.toRadians((angle * i - 90))
        val x = (center.x + radius * cos(theta)).toFloat()
        val y = (center.y + radius * sin(theta)).toFloat()

        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }

        val halfTheta = Math.toRadians((angle * i + halfAngle - 90))
        val xHalf = (center.x + radius / 2 * cos(halfTheta)).toFloat()
        val yHalf = (center.y + radius / 2 * sin(halfTheta)).toFloat()

        path.lineTo(xHalf, yHalf)
    }

    path.close()
    return path
}

private fun DrawScope.drawRatingStar(
    fillPercentage: Float,
    emptyColor: Color,
    fillColor: Color
) {
    val starPath = createStarPath(size.minDimension / 2, size.center)

    // Draw the empty star
    drawPath(
        path = starPath,
        color = emptyColor
    )

    // Draw the filled portion of the star
    if (fillPercentage > 0f) {
        drawIntoCanvas { canvas ->
            canvas.withSaveLayer(Rect(Offset.Zero, size), Paint()) {
                // Draw the full star
                drawPath(
                    path = starPath,
                    color = fillColor
                )

                // Clip the filled portion
                drawRect(
                    color = Color.Transparent,
                    topLeft = Offset(size.width * fillPercentage, 0f),
                    size = Size(size.width * (1 - fillPercentage), size.height),
                    blendMode = BlendMode.SrcIn
                )
            }
        }
    }
}

@Suppress("UndocumentedPublicFunction")
@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(
        rating = 3.8f,
        starSize = 30.dp,
        spacing = 4.dp,
        emptyColor = Color.Gray,
        fillColor = Color.Yellow
    )
}
