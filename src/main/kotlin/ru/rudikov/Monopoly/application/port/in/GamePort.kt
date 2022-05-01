package ru.rudikov.Monopoly.application.port.`in`

import ru.rudikov.Monopoly.domain.Game
import ru.rudikov.Monopoly.domain.GameRequest

interface GamePort {

    fun start(request: GameRequest): Game
}