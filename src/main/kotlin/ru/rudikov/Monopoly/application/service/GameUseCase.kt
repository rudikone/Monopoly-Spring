package ru.rudikov.Monopoly.application.service

import org.springframework.stereotype.Service
import ru.rudikov.Monopoly.application.port.`in`.CellPort
import ru.rudikov.Monopoly.application.port.`in`.ChipPort
import ru.rudikov.Monopoly.application.port.`in`.GamePort
import ru.rudikov.Monopoly.application.port.out.GamePersistancePort
import ru.rudikov.Monopoly.domain.Game
import ru.rudikov.Monopoly.domain.GameRequest

@Service
class GameUseCase(
    private val chipPort: ChipPort,
    private val cellPort: CellPort,
    private val gamePersistancePort: GamePersistancePort
) : GamePort {

    override fun start(request: GameRequest): Game {
        val chips = chipPort.createChips(request)
        val cells = cellPort.createCells()

        val game = Game(chips = chips, cells = cells)

        return gamePersistancePort.save(game)
    }
}