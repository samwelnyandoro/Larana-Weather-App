package com.weatherapp.weatherapp.data.pollutionModels

data class Pollution(
    val components: Components,
    val dt: Int,
    val main: Main
)