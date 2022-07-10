package ru.rudikov.Monopoly.domain.exception

data class MonopolyError(
    private val statusCode: Int,
    private val message: String?,
)