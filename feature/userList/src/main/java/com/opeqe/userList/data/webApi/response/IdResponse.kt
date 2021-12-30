package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName
data class IdResponse (

	@SerializedName("name") val name : String?=null,
	@SerializedName("value") val value : String?=null
)