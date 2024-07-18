package com.waminiyi.zeplaces.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.waminiyi.zeplaces.R

/**
 * Represents different types of places.
 * @property typeName The human-readable name of the place type.
 */
enum class PlaceType(
    @StringRes val typeName: Int,
    @StringRes val typeKey: Int,
    @DrawableRes val iconResourceId: Int
) {

    /** Represents a restaurant. */
    RESTAURANT(R.string.restaurants, R.string.restaurant_key, R.drawable.restaurant),

    /** Represents an ATM. */
    ATM(R.string.atm, R.string.atm_key, R.drawable.atm),

    /** Represents a gas station. */
    GAS(R.string.gas_station, R.string.gas_key, R.drawable.gas),

    /** Represents a bakery. */
    BAKERY(R.string.bakery, R.string.bakery_key, R.drawable.bakery),

}

