package com.devside.springkotlinsandbox

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {
        val user = userRepository.save(User("user01", "chanwook", "park"))

        articleRepository.save(Article(
                title = "Title1",
                headline = "Headline...",
                content = "content...",
                author = user
        ))

        articleRepository.save(Article(
                title = "Title2",
                headline = "Headline...",
                content = "content...",
                author = user
        ))
    }
}