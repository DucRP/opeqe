package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName
data class UserResponse (

	@SerializedName("gender") val gender : String?=null,
	@SerializedName("name") val name : NameResponse?=null,
	@SerializedName("location") val location : Location?=null,
	@SerializedName("email") val email : String?=null,
	@SerializedName("login") val login : LoginResponse?=null,
	@SerializedName("dob") val dob : DobResponse?=null,
	@SerializedName("registered") val registered : RegisteredResponse?=null,
	@SerializedName("phone") val phone : String?=null,
	@SerializedName("cell") val cell : String?=null,
	@SerializedName("id") val id : IdResponse?=null,
	@SerializedName("picture") val picture : PictureResponse?=null,
	@SerializedName("nat") val nat : String?=null
)