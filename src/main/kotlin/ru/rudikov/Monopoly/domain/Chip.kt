package ru.rudikov.Monopoly.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Chip(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    @JsonBackReference
    var game: Game? = null,
)
