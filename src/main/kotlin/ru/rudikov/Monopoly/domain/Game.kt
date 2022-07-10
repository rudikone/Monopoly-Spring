package ru.rudikov.Monopoly.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.Instant
import javax.persistence.*

@Entity
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val created: Instant = Instant.now(),
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    @JsonManagedReference
    val cells: List<Cell>? = null,
    @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
    @JsonManagedReference
    val chips: List<Chip>? = null,
)
