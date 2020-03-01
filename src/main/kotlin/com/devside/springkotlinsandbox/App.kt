package com.devside.springkotlinsandbox

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class App

fun main(args: Array<String>) {
    runApplication<App>(*args) {
        //		setBannerMode(Banner.Mode.OFF)
    }
}
