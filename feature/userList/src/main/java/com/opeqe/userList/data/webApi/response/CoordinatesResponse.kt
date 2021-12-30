package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName

data class CoordinatesResponse (

	@SerializedName("latitude") val latitude : Double?=null,
	@SerializedName("longitude") val longitude : Double?=null
)