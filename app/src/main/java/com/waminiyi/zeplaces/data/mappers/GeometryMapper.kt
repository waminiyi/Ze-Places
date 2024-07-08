package com.waminiyi.zeplaces.data.mappers

import com.waminiyi.zeplaces.domain.model.Coordinates
import com.waminiyi.zeplaces.remote.dto.GeometryDto

/**
 * Extension of [GeometryDto].
 * Maps an [GeometryDto] to an [Coordinates].
 *
 */
fun GeometryDto.toCoordinates() =
    Coordinates(latitude = this.location.lat, longitude = this.location.lng)
