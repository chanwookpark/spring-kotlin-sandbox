package com.devside.springkotlinsandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

// todo 2. 클래스의 ()는 무슨 의미일까? -> 생성자!!
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setups")
    }

    @Test
    internal fun `HTML 페이지 타이틀 값 전달 확인`() {
        println(">> test1")

        val entity = restTemplate.getForEntity<String>("/")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>HOME</h1>")
    }

    @Test
    internal fun callLifeCycle() {
        println(">> test2")
    }

    @AfterAll
    fun tearDown() {
        println(">> TearDown")
    }
}