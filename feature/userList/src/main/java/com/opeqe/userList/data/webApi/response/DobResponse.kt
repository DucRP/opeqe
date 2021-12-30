package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName

data class DobResponse (

	@SerializedName("date") val date : String?=null,
	@SerializedName("age") val age : Int?=null
)