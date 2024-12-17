package org.example.baseapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BaseAppApplication

fun main(args: Array<String>) {
    runApplication<BaseAppApplication>(*args)
}
