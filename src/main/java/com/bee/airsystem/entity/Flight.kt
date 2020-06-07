package com.bee.airsystem.entity

data class Flight(
        val id: Int,
        var PlaneId: String,
        var departure: String,
        var destination: String,
        var price: Double,
        var startTime: String,
        var arrivalTime: String
)