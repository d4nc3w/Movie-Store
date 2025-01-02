package com.example.moviestoreapplication.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartWithUppercaseValidator implements ConstraintValidator<StartWithUppercase, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        boolean isValid;

        if(password == null || password.isEmpty()){
            isValid = true;
        } else {
            char firstLetter = password.charAt(0);
            if(Character.isUpperCase(firstLetter)){
                isValid = false;
            } else {
                isValid = true;
            }
        }
        return isValid;
    }

    @Override
    public void initialize(StartWithUppercase constraintAnnotation) {
    }
}
