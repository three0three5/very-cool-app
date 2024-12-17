package org.example.featureservice.controller

import org.example.featureservice.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundException(ex: NotFoundException): ErrorResponse {
        return ErrorResponse.create(
            ex,
            HttpStatus.NOT_FOUND,
            ex.message ?: "Entity not found")
    }
}