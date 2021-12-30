package io.phoenix.businessmessenger.data.entity

import com.google.gson.annotations.SerializedName


data class Status(

    @SerializedName("timestamp") var timestamp: String,
    @SerializedName("error_code") var errorCode: Int,
    @SerializedName("error_message") var errorMessage: String,
    @SerializedName("elapsed") var elapsed: Int,
    @SerializedName("credit_count") var creditCount: Int,
    @SerializedName("notice") var notice: String

)