package com.waminiyi.zeplaces.domain.model

/**
 * Represents an address with a name and geographical coordinates.
 * @property addressName The human-readable name for the address.
 * @property coordinates The geographical coordinates of the address.
 */
data class Address(
    val addressName: String?,
    val coordinates: Coordinates?
)
