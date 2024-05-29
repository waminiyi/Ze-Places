package com.waminiyi.zeplaces.data.mappers

import com.waminiyi.zeplaces.data.cache.room.SavedPlaceEntity
import com.waminiyi.zeplaces.domain.model.Address
import com.waminiyi.zeplaces.domain.model.Coordinates
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
        isSaved = false
    )

fun PlaceOfInterest.toSavedPlaceEntity() =
    SavedPlaceEntity(
        id = this.id,
        name = this.name,
        rating = this.rating,
        ratingCount = this.ratingCount,
        addressName = this.address.addressName,
        latitude = this.address.coordinates?.latitude,
        longitude = this.address.coordinates?.longitude,
        isOpenNow = this.isOpenNow,
        photoUrl = this.photoUrl,
        isSaved = this.isSaved
    )

fun SavedPlaceEntity.toPlaceOfInterest() =
    PlaceOfInterest(
        id = this.id,
        name = this.name,
        rating = this.rating,
        ratingCount = this.ratingCount,
        address = Address(
            addressName = this.addressName,
            coordinates = Coordinates(
                latitude = this.latitude,
                longitude = this.longitude
            )
        ),
        isOpenNow = this.isOpenNow,
        photoUrl = this.photoUrl,
        isSaved = this.isSaved,
        distance = null
    )