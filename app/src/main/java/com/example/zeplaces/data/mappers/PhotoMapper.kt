package com.example.zeplaces.data.mappers

import com.waminiyi.zeplaces.BuildConfig
import com.waminiyi.zeplaces.remote.dto.PhotoDto

const val photoBaseUrl =
    "https://maps.googleapis.com/maps/api/place/photo?"

fun PhotoDto.toUrl() =
    "${photoBaseUrl}maxwidth=${this.width}&photoreference=${this.photoReference}&key=${BuildConfig.MAPS_API_KEY}"
