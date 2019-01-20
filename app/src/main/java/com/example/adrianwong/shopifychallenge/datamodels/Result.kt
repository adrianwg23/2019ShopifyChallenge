package com.example.adrianwong.shopifychallenge.datamodels

sealed class Result<out E, out V> {

    data class Value<out V>(val value: V) : Result<Nothing, V>()
    data class Error<out E>(val error: E) : Result<E, Nothing>()

    companion object Factory {
        fun buildError(error: Exception): Result<Exception, Nothing> {
            return Error(error)
        }

        fun <V>buildValue(value: V): Result<Nothing, V> {
            return Value(value)
        }
    }
}