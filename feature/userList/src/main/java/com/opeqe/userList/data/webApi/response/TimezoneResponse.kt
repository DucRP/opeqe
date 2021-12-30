package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName
data class TimezoneResponse (

	@SerializedName("offset") val offset : String?=null,
	@SerializedName("description") val description : String?=null
)