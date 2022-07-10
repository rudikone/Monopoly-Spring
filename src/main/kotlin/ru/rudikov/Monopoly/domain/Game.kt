package ru.rudikov.Monopoly.domain

import java.time.Instant
import javax.persistence.*

@Entity
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val created: Instant = Instant.now(),
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    val cells: List<Cell>?,
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    val chips: List<Chip>?,
)
