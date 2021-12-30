package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName

data class PictureResponse (

	@SerializedName("large") val large : String?=null,
	@SerializedName("medium") val medium : String?=null,
	@SerializedName("thumbnail") val thumbnail : String?=null
)