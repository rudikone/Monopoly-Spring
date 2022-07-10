package ru.rudikov.Monopoly.repository

import io.kotest.matchers.collections.shouldHaveSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import ru.rudikov.Monopoly.adapter.`in`.GameController
import ru.rudikov.Monopoly.adapter.out.GameRepository
import ru.rudikov.Monopoly.common.createChips
import ru.rudikov.Monopoly.common.createGame
import ru.rudikov.Monopoly.container.PostgresTestContainer

//@ContextConfiguration(classes = [GameRepository::class, MonopolyApplication::class])
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GameRepositoryTest() : PostgresTestContainer {

    @Autowired
    private lateinit var repository: GameRepository

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Test
    fun `should save game`() {
        val chips = createChips(listOf("Zhenya", "Yulya"))
        val game = createGame(chips = chips)

        entityManager.persist(game)
        entityManager.flush()

        repository.findAll() shouldHaveSize 1
    }
}