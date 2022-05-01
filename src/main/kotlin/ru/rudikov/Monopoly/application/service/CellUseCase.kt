package ru.rudikov.Monopoly.application.service

import org.springframework.stereotype.Service
import ru.rudikov.Monopoly.application.port.`in`.CellPort
import ru.rudikov.Monopoly.domain.Cell

@Service
class CellUseCase : CellPort {

    override fun createCells(): List<Cell> = cells
}

private val cells = listOf(
    Cell(name = "Start"),
    Cell(name = "Parking")
)