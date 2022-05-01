package ru.rudikov.Monopoly.domain

import javax.persistence.*

@Entity
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    val cells: List<Cell>,
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    val chips: List<Chip>,
)
