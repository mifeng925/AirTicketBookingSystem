package com.bee.airsystem.entity

data class Flight(
        val id: Int,
        var planeId: String,
        var planeName: String,
        var departure: String,
        var destination: String,
        var price: Double,
        var flag: Int,
        var startTime: String,
        var arrivalTime: String
) {
    constructor(id: Int,
                planeId: String,
                departure: String,
                destination: String,
                price: Double,
                flag: Int,
                startTime: String,
                arrivalTime: String
    ) : this(id, planeId, "", departure, destination, price, flag, startTime, arrivalTime)

    constructor(id: Int) : this(id, "", "","" , "",0.0 , 0, "","" )

}