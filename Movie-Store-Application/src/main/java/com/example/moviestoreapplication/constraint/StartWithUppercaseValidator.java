package com.example.moviestoreapplication.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartWithUppercaseValidator implements ConstraintValidator<StartWithUppercase, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if(password == null || password.isEmpty()){
            return true;
        } else {
            char firstLetter = password.charAt(0);
            if(Character.isUpperCase(firstLetter)){
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void initialize(StartWithUppercase constraintAnnotation) {
    }
}
