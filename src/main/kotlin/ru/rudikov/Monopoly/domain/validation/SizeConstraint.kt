package ru.rudikov.Monopoly.domain.validation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Constraint(validatedBy = [SizeValidator::class])
annotation class SizeConstraint(
    val message: String = "В игре может участвовать от 2 до 6 игроков!",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class SizeValidator : ConstraintValidator<SizeConstraint, List<String>> {
    override fun isValid(value: List<String>, context: ConstraintValidatorContext?): Boolean {
        return value.size in 2..6
    }

}
