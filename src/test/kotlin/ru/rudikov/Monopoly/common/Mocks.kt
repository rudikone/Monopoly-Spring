package ru.rudikov.Monopoly.common

import ru.rudikov.Monopoly.domain.Cell
import ru.rudikov.Monopoly.domain.Chip
import ru.rudikov.Monopoly.domain.Game
import java.time.Instant

fun createGame(
    cells: List<Cell>? = createCells(),
    chips: List<Chip>? = createChips(),
    created: Instant = Instant.now()
) = Game(cells = cells, chips = chips, created = created)

fun createCells(
    names: List<String> = listOf("Parking", "Start")
) = names.map { Cell(name = it) }

fun createChips(
    names: List<String> = listOf("Parking", "Start")
) = names.map { Chip(name = it) }