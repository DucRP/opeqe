package io.phoenix.businessmessenger.data.entity

class ServerException(message: String, val code: Int = -1) : Exception(message)
