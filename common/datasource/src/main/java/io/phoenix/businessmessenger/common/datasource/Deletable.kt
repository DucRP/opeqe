package io.phoenix.businessmessenger.common.datasource

interface Deletable<I> {

    fun delete(input: I)

    interface IO<I, O> {

        fun delete(input: I): O
    }

    interface Suspendable<I> {

        suspend fun delete(input: I)

        interface IO<I, O> {

            suspend fun delete(input: I): O
        }
    }
}