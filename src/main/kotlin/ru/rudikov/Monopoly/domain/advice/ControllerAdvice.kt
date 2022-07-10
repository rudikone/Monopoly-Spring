package ru.rudikov.Monopoly.domain.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.rudikov.Monopoly.domain.exception.MonopolyError

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): MonopolyError =
        MonopolyError(
            statusCode = HttpStatus.BAD_REQUEST.value(),
            message = ex.message,
        )

    @ExceptionHandler(value = [Throwable::class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    fun handleException(ex: Throwable): MonopolyError =
        MonopolyError(
            statusCode = HttpStatus.BAD_REQUEST.value(),
            message = ex.message,
        )

}