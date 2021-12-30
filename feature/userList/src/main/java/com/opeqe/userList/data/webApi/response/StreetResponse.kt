package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName
data class StreetResponse (

	@SerializedName("number") val number : Int?=null,
	@SerializedName("name") val name : String?=null
)