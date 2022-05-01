package ru.rudikov.Monopoly.domain

import ru.rudikov.Monopoly.domain.validation.SizeConstraint

data class GameRequest(
    @SizeConstraint
    val chipNames: List<String>,
)
