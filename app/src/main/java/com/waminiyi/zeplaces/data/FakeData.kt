package com.waminiyi.zeplaces.data

import com.waminiyi.zeplaces.data.mappers.toPlaceOfInterest
import com.waminiyi.zeplaces.remote.dto.GeometryDto
import com.waminiyi.zeplaces.remote.dto.LocationDto
import com.waminiyi.zeplaces.remote.dto.OpeningHoursDto
import com.waminiyi.zeplaces.remote.dto.PhotoDto
import com.waminiyi.zeplaces.remote.dto.PlaceDto

private val placeDtos = listOf(
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8587323,
                lng = 151.2100055
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/bar-71.png",
        iconBackgroundColor = "#FF9E67",
        name = "Cruise Bar",
        openingHours = OpeningHoursDto(
            openNow = true
        ),
        photos = listOf(
            PhotoDto(
                height = 575,
                width = 766,
                photoReference = "AUc7tXW31EtNBGo9q4OIUdMr8pwYOQitNLPWNlvdLFkLhL_Wyr7OCr8_0Ze-37JyT1a6wcUows1RxdFZqo17rgbvXWBSBMCzDBkOH4ALG_5CBOaEYpe-ZQANno7x8RPiWAxMn7fzoJXTOt9txq2zFwmUfc3vadRk00ev0DiDjhpoaSjJnKcq"
            )
        ),
        placeId = "ChIJi6C1MxquEmsR9-c-3O48ykI",
        rating = 4.0f,
        types = listOf("bar", "restaurant", "food", "point_of_interest", "establishment"),
        userRatingsTotal = 1749,
        vicinity = "Level 1, 2 and 3, Overseas Passenger Terminal, Circular Quay W, The Rocks"
    ),
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8675219,
                lng = 151.2016502
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
        iconBackgroundColor = "#7B9EB0",
        name = "Sydney Harbour Dinner Cruises",
        openingHours = OpeningHoursDto(
            openNow = true
        ),
        photos = listOf(
            PhotoDto(
                height = 835,
                width = 1200,
                photoReference = "AUc7tXUhmgz33ev0kqzAIkBe_NCbOsS9HnwnlEhgQmh1nvMo9aNkomZjlVcXBQaGf5NKkfMC3rp7TsNYuHguXpxW6QT2xI3Sppu5ur6HLy-mJAxSNJJ_zSvEyy40mCe7V8plIEZg1JQLazTI764Ea-qcVPnQxrqNLPNbw3ba4j8GpdtLm-AO"
            )
        ),
        placeId = "ChIJM1mOVTS6EmsRKaDzrTsgids",
        rating = 4.5f,
        types = listOf(
            "travel_agency",
            "tourist_attraction",
            "restaurant",
            "food",
            "point_of_interest",
            "establishment"
        ),
        userRatingsTotal = 47,
        vicinity = "32 The Promenade, Sydney"
    ),
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8677035,
                lng = 151.2017297
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
        iconBackgroundColor = "#7B9EB0",
        name = "Sydney Harbour Lunch Cruise",
        openingHours = OpeningHoursDto(
            openNow = false
        ),
        photos = listOf(
            PhotoDto(
                height = 1152,
                width = 2048,
                photoReference = "AUc7tXVEHO-o4nYQltCnHfCIEMS9Z-HyAKYazVEJJw9STs53QW1IneOsUH8sChBJ_dDDs8kSaVFKiX9gM_GitSSOTpcYTY11e8GJEoXxLDBjh3qPSuHvxh4ZWmIQOasbkDgmlzJj1xgHGWtpsje-uol2CwIW5KHQn7TFiW9EFPbf2_qi-gAr"
            )
        ),
        placeId = "ChIJUbf3iDiuEmsROJxXbhYO7cM",
        rating = 4.2f,
        types = listOf("travel_agency", "restaurant", "food", "point_of_interest", "establishment"),
        userRatingsTotal = 30,
        vicinity = "King Street Wharf, 5/32 The Promenade, Sydney"
    ),
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8587323,
                lng = 151.2100055
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/bar-71.png",
        iconBackgroundColor = "#FF9E67",
        name = "Cruise Bar",
        openingHours = OpeningHoursDto(
            openNow = true
        ),
        photos = listOf(
            PhotoDto(
                height = 575,
                width = 766,
                photoReference = "AUc7tXW31EtNBGo9q4OIUdMr8pwYOQitNLPWNlvdLFkLhL_Wyr7OCr8_0Ze-37JyT1a6wcUows1RxdFZqo17rgbvXWBSBMCzDBkOH4ALG_5CBOaEYpe-ZQANno7x8RPiWAxMn7fzoJXTOt9txq2zFwmUfc3vadRk00ev0DiDjhpoaSjJnKcq"
            )
        ),
        placeId = "ChIJi6C1MxquEmsR9-c-3O48ykI",
        rating = 4.0f,
        types = listOf("bar", "restaurant", "food", "point_of_interest", "establishment"),
        userRatingsTotal = 1749,
        vicinity = "Level 1, 2 and 3, Overseas Passenger Terminal, Circular Quay W, The Rocks"
    ),
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8675219,
                lng = 151.2016502
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
        iconBackgroundColor = "#7B9EB0",
        name = "Sydney Harbour Dinner Cruises",
        openingHours = OpeningHoursDto(
            openNow = true
        ),
        photos = listOf(
            PhotoDto(
                height = 835,
                width = 1200,
                photoReference = "AUc7tXUhmgz33ev0kqzAIkBe_NCbOsS9HnwnlEhgQmh1nvMo9aNkomZjlVcXBQaGf5NKkfMC3rp7TsNYuHguXpxW6QT2xI3Sppu5ur6HLy-mJAxSNJJ_zSvEyy40mCe7V8plIEZg1JQLazTI764Ea-qcVPnQxrqNLPNbw3ba4j8GpdtLm-AO"
            )
        ),
        placeId = "ChIJM1mOVTS6EmsRKaDzrTsgids",
        rating = 4.5f,
        types = listOf(
            "travel_agency",
            "tourist_attraction",
            "restaurant",
            "food",
            "point_of_interest",
            "establishment"
        ),
        userRatingsTotal = 47,
        vicinity = "32 The Promenade, Sydney"
    ),
    PlaceDto(
        businessStatus = "OPERATIONAL",
        geometry = GeometryDto(
            location = LocationDto(
                lat = -33.8677035,
                lng = 151.2017297
            )
        ),
        icon = "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/generic_business-71.png",
        iconBackgroundColor = "#7B9EB0",
        name = "Sydney Harbour Lunch Cruise",
        openingHours = OpeningHoursDto(
            openNow = false
        ),
        photos = listOf(
            PhotoDto(
                height = 1152,
                width = 2048,
                photoReference = "AUc7tXVEHO-o4nYQltCnHfCIEMS9Z-HyAKYazVEJJw9STs53QW1IneOsUH8sChBJ_dDDs8kSaVFKiX9gM_GitSSOTpcYTY11e8GJEoXxLDBjh3qPSuHvxh4ZWmIQOasbkDgmlzJj1xgHGWtpsje-uol2CwIW5KHQn7TFiW9EFPbf2_qi-gAr"
            )
        ),
        placeId = "ChIJUbf3iDiuEmsROJxXbhYO7cM",
        rating = 4.2f,
        types = listOf("travel_agency", "restaurant", "food", "point_of_interest", "establishment"),
        userRatingsTotal = 30,
        vicinity = "King Street Wharf, 5/32 The Promenade, Sydney"
    )
)

val fakePlacesOfInterest = placeDtos.map { it.toPlaceOfInterest() }
