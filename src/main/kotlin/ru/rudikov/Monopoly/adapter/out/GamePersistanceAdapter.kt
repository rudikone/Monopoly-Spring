package ru.rudikov.Monopoly.adapter.out

import org.springframework.stereotype.Service
import ru.rudikov.Monopoly.application.port.out.GamePersistancePort
import ru.rudikov.Monopoly.domain.Game

@Service
class GamePersistanceAdapter(private val repository: GameRepository) : GamePersistancePort {

    override fun save(game: Game) = repository.save(game)

}