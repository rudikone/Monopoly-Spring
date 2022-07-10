package ru.rudikov.Monopoly.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Cell(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    @JsonBackReference
    var game: Game? = null,
)