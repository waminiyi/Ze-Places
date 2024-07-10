package com.waminiyi.zeplaces.di

import com.google.android.gms.location.LocationServices
import com.waminiyi.zeplaces.ui.presentation.PlacesViewModel
import com.waminiyi.zeplaces.ui.utils.LocationTracker
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single<LocationTracker> {
        LocationTracker(
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(
                androidApplication()
            ),
            application = androidApplication()
        )
    }

    viewModel {
        PlacesViewModel(
            placeRepository = get(),
            locationTracker = get()
        )
    }
}