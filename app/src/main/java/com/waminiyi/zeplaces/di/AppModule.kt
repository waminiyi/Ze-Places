package com.waminiyi.zeplaces.di

import com.waminiyi.zeplaces.remote.api.PlaceApi
import com.waminiyi.zeplaces.ui.presentation.PlacesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        PlacesViewModel(
            placeRepository = get()
        )
    }
}