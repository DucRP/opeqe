package io.phoenix.businessmessenger.data.entity


data class LocalException(
    var errorId: Int = 0,
    override val message: String = "",
    val code: Int = -1
) :
    Exception(message)
