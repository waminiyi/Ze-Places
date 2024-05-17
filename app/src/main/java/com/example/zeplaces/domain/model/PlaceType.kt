package com.example.zeplaces.domain.model

/**
 * Represents different types of places.
 * @property value The human-readable name of the place type.
 */
enum class PlaceType(val value: String) {
    /** Represents a grocery store. */
    GROCERY(GROCERIES_NAME),

    /** Represents a restaurant. */
    RESTAURANT(RESTAURANTS_NAME),

    /** Represents an ATM. */
    ATM(ATM_NAME),

    /** Represents a gas station. */
    GAS(GAS_NAME),

    /** Represents a bakery. */
    BAKERY(BAKERY_NAME),

    /** Represents a hotel. */
    HOTEL(HOTELS_NAME)
}

/** The human-readable name for groceries. */
const val GROCERIES_NAME = "Groceries"

/** The human-readable name for restaurants. */
const val RESTAURANTS_NAME = "Restaurants"

/** The human-readable name for ATMs. */
const val ATM_NAME = "ATM"

/** The human-readable name for gas stations. */
const val GAS_NAME = "Gas"

/** The human-readable name for bakeries. */
const val BAKERY_NAME = "Bakery"

/** The human-readable name for hotels. */
const val HOTELS_NAME = "Hotels"
