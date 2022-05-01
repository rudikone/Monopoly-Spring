package ru.rudikov.Monopoly.domain

import javax.persistence.*

@Entity
class Cell(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    val game: Game? = null,
)