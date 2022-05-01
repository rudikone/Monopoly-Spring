package ru.rudikov.Monopoly.application.port.`in`

import ru.rudikov.Monopoly.domain.Cell

interface CellPort {

    fun createCells(): List<Cell>
}