package com.bee.airsystem.entity

import com.bee.airsystem.annotation.FieldName
import com.bee.airsystem.annotation.Ignore
import com.bee.airsystem.annotation.TableName


@TableName("")
data class AviationSystem(
        @FieldName("_id") var id: Int,
        var name: String,
        var sex: String,
        @FieldName("work_unit") var workUnit: String,
        @FieldName("identity_card") var identityCard: String,
        @FieldName("travel_time") var travelTime: String,
        var departure: String,
        var destination: String,
        @FieldName("shipping_space") var shippingSpace: String,
        @Ignore var test: String
)


