package com.opeqe.userList.data.webApi.response

import com.google.gson.annotations.SerializedName

data class NameResponse (

	@SerializedName("title") val title : String?=null,
	@SerializedName("first") val first : String?=null,
	@SerializedName("last") val last : String?=null
){
	fun getFullName():String= "$first $last"

}