package io.phoenix.businessmessenger.data.entity
import com.google.gson.annotations.SerializedName


data class BaseResponse<T>(
    @SerializedName("status") var info: InfoResponse? = null,
    @SerializedName("results") var results: T
)
