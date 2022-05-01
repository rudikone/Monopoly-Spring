package ru.rudikov.Monopoly.adapter.`in`

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rudikov.Monopoly.application.port.`in`.GamePort
import ru.rudikov.Monopoly.domain.Game
import ru.rudikov.Monopoly.domain.GameRequest

@Validated
@RestController(value = "/api")
class GameController(
    private val gamePort: GamePort
) {

    @PostMapping("/game")
    fun start(@RequestBody @Valid request: GameRequest): ResponseEntity<Game> =
        ResponseEntity(gamePort.start(request), HttpStatus.CREATED)
}