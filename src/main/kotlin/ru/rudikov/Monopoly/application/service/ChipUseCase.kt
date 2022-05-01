package ru.rudikov.Monopoly.application.service

import org.springframework.stereotype.Service
import ru.rudikov.Monopoly.application.port.`in`.ChipPort
import ru.rudikov.Monopoly.domain.Chip
import ru.rudikov.Monopoly.domain.GameRequest

@Service
class ChipUseCase : ChipPort {

    override fun createChips(request: GameRequest): List<Chip> =
        request.chipNames.map {
            Chip(name = it)
        }

}