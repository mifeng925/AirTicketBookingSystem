package com.bee.airsystem.entity

data class UserBase(
        var userName: String? = "",
        var nickName: String? = "",
        var sex: String? = "",
        var workUnit: String? = "",
        var identityCard: String? = "",
        var email: String? = "",
        var power: Int = 0,
        var phone: String? = "",
        var passWord: String? = "",
        var createTime: String? = "",
        var updateTime: String? = ""
) {
    constructor(identityCard: String) : this("", identityCard = identityCard)
}
