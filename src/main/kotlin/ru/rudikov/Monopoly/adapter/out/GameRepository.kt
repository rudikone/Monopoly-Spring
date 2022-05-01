package ru.rudikov.Monopoly.adapter.out

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.rudikov.Monopoly.domain.Game

@Repository
interface GameRepository : JpaRepository<Game, Long> {
}