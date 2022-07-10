package ru.rudikov.Monopoly.domain.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import ru.rudikov.Monopoly.domain.exception.MonopolyApiError

fun MethodArgumentNotValidException.toApiError(): MonopolyApiError {
    val fieldMessages = this.bindingResult.fieldErrors.map { "${it.field}: ${it.defaultMessage}" }
    val objectMessages = this.bindingResult.globalErrors.map { "${it.objectName}: ${it.defaultMessage}" }

    val resultMessage = if ((fieldMessages + objectMessages).isEmpty())
        UNKNOWN_EXCEPTION_MESSAGE else
        (fieldMessages + objectMessages).joinToString()

    return MonopolyApiError(
        statusCode = HttpStatus.BAD_REQUEST.value(),
        message = resultMessage,
    )
}

fun Throwable.toApiError(): MonopolyApiError = MonopolyApiError(
    statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    message = this.message ?: UNKNOWN_EXCEPTION_MESSAGE,
)


const val UNKNOWN_EXCEPTION_MESSAGE = "UNKNOWN_EXCEPTION_MESSAGE"
