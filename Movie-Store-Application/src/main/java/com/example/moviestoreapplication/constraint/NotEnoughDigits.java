package com.example.moviestoreapplication.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotEnoughDigitsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEnoughDigits {
    String message() default "Password should contain at least one digit";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
