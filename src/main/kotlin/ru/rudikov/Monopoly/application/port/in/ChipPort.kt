package ru.rudikov.Monopoly.application.port.`in`

import ru.rudikov.Monopoly.domain.Chip
import ru.rudikov.Monopoly.domain.GameRequest

interface ChipPort {

    fun createChips(request: GameRequest): List<Chip>
}