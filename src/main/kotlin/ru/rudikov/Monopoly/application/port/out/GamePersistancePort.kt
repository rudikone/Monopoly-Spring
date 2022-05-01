package ru.rudikov.Monopoly.application.port.out

import ru.rudikov.Monopoly.domain.Game

interface GamePersistancePort {

    fun save(game: Game): Game
}