package com.waminiyi.zeplaces.data.mappers

import com.waminiyi.zeplaces.BuildConfig
import com.waminiyi.zeplaces.remote.dto.PhotoDto

const val PHOTO_BASE_URL =
    "https://maps.googleapis.com/maps/api/place/photo?"

/**
 * Extension of [PhotoDto].
 * Maps an [PhotoDto] to its string url representation.
 *
 */
fun PhotoDto.toUrl() =
    "${PHOTO_BASE_URL}maxwidth=${this.width}&photoreference=${this.photoReference}&key=${BuildConfig.MAPS_API_KEY}"
