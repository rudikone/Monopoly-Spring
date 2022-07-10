package ru.rudikov.Monopoly.domain.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.rudikov.Monopoly.domain.exception.MonopolyApiError

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException) =
        handle(apiModelError = ex.toApiError(), status = HttpStatus.BAD_REQUEST.value())

    @ExceptionHandler(Throwable::class)
    fun handleException(ex: Throwable) =
        handle(apiModelError = ex.toApiError(), status = HttpStatus.INTERNAL_SERVER_ERROR.value())

    private fun handle(apiModelError: MonopolyApiError, status: Int): ResponseEntity<MonopolyApiError> =
        ResponseEntity.status(status).body(apiModelError)

}