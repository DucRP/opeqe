package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName
data class Location (

    @SerializedName("street") val street : StreetResponse?=null,
    @SerializedName("city") val city : String?=null,
    @SerializedName("state") val state : String?=null,
    @SerializedName("country") val country : String?=null,
    @SerializedName("postcode") val postcode : Int?=null,
    @SerializedName("coordinates") val coordinates : CoordinatesResponse?=null,
    @SerializedName("timezone") val timezone : TimezoneResponse?=null
)