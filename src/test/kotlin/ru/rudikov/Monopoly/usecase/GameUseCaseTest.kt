package ru.rudikov.Monopoly.usecase

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.rudikov.Monopoly.application.service.GameUseCase
import ru.rudikov.Monopoly.container.PostgresTestContainer
import ru.rudikov.Monopoly.domain.GameRequest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameUseCaseTest : PostgresTestContainer {

    @Autowired
    private lateinit var gameUseCase: GameUseCase

    @Test
    fun `should save game`() {
        val request = GameRequest(
            chipNames = listOf("Bear", "Matryoshka")
        )
        gameUseCase.start(request)


    }
}