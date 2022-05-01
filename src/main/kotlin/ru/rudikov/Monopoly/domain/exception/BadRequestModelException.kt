package ru.rudikov.Monopoly.domain.exception

data class BadRequestModelException(
    override val message: String?
) : RuntimeException()
