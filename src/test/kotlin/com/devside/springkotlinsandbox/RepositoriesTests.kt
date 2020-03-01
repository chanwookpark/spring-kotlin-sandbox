package com.devside.springkotlinsandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository
) {
    @Test
    fun `When findByIdOrNull then return Article`() {
        val user = User("man", "First", "Last")
        entityManager.persist(user)

        val article = Article("Spring+Kotlin test", "spring+kotlin", "blah blah", user)
        entityManager.persist(article)

        entityManager.flush()

        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val user = User("man", "First", "Last")
        entityManager.persist(user)
        entityManager.flush()

        val found = userRepository.findByLogin(user.login)
        assertThat(found).isEqualTo(user)
    }
}