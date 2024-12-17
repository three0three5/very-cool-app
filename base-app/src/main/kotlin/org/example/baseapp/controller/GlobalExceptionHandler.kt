package org.example.baseapp.controller

import org.example.baseapp.exception.EmptyResponseException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.reactive.function.client.WebClientRequestException
import java.net.ConnectException

data class ErrorResponse(val errorCode: String, val message: String)

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(EmptyResponseException::class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    fun handleEmptyResponseException(e: EmptyResponseException): ErrorResponse {
        return ErrorResponse(
            e.exceptionKey.name,
            e.exceptionKey.description
        )
    }

    @ExceptionHandler(WebClientRequestException::class, ConnectException::class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    fun handleWebClientRequestException(e: Exception): ErrorResponse {
        return ErrorResponse(
            e.localizedMessage,
            "Could not get response from external service"
        )
    }
}