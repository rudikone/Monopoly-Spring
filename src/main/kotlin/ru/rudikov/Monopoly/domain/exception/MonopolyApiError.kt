package ru.rudikov.Monopoly.domain.exception

open class MonopolyApiError(
    val statusCode: Int,
    val message: String,
)