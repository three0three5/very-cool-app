package org.example.baseapp.controller

import mu.KLogging
import org.example.baseapp.service.SomeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/calculate"])
class SomeController(
    private val service: SomeService
) {
    @GetMapping
    fun getSquareOfNumber(@RequestParam number: Int): Int {
        logger.info { "Processing the number $number" }
        return service.calculateNumber(number)
    }

    companion object: KLogging()
}