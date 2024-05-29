package com.waminiyi.zeplaces.data.mappers

import com.waminiyi.zeplaces.domain.model.PlaceType

/**
 * Extension of [PlaceType].
 * Maps an [PlaceType] to the corresponding string key.
 *
 */
fun PlaceType.getKey() = when (this) {
    PlaceType.RESTAURANT -> "restaurant"
    PlaceType.ATM -> "atm"
    PlaceType.GAS -> "gas"
    PlaceType.HOTEL -> "hotel"
    PlaceType.BAKERY -> "bakery"
    PlaceType.GROCERY -> "grocery"
}
