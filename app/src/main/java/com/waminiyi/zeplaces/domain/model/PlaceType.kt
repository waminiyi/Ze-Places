package com.waminiyi.zeplaces.domain.model

import androidx.annotation.DrawableRes
import com.waminiyi.zeplaces.R

/**
 * Represents different types of places.
 * @property typeName The human-readable name of the place type.
 */
enum class PlaceType(val typeName: String, val typeKey: String, @DrawableRes val iconResourceId: Int) {


    /** Represents a restaurant. */
    RESTAURANT(RESTAURANTS_NAME, "restaurant", R.drawable.restaurant),

    /** Represents an ATM. */
    ATM(ATM_NAME,"atm", R.drawable.atm),

    /** Represents a gas station. */
    GAS(GAS_NAME,"gas_station", R.drawable.gas),

    /** Represents a bakery. */
    BAKERY(BAKERY_NAME, "bakery", R.drawable.bakery),

}

/** The human-readable name for restaurants. */
const val RESTAURANTS_NAME = "Restaurants"

/** The human-readable name for ATMs. */
const val ATM_NAME = "ATM"

/** The human-readable name for gas stations. */
const val GAS_NAME = "Gas"

/** The human-readable name for bakeries. */
const val BAKERY_NAME = "Bakery"

