package com.waminiyi.zeplaces.data.mappers

import com.waminiyi.zeplaces.domain.model.Address
import com.waminiyi.zeplaces.domain.model.PlaceOfInterest
import com.waminiyi.zeplaces.remote.dto.PlaceDto
import java.util.UUID

fun PlaceDto.toPlaceOfInterest() =
    PlaceOfInterest(
        id = this.placeId ?: UUID.randomUUID().toString(),
        name = this.name,
        rating = this.rating,
        ratingCount = this.userRatingsTotal,
        address = Address(
            addressName = this.vicinity,
            coordinates = this.geometry?.toCoordinates()
        ),
        isOpenNow = this.openingHours?.openNow,
        photoUrl = this.photos?.first()?.toUrl(),
        distance = null,
        isFavorite = false
    )