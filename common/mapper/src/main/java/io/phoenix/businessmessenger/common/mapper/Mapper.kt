package io.phoenix.businessmessenger.common.mapper

interface Mapper<First, Second> {

    fun map(first: First): Second
}
