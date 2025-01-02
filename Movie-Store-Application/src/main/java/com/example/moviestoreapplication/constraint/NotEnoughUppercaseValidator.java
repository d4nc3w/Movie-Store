package com.example.moviestoreapplication.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEnoughUppercaseValidator implements ConstraintValidator<NotEnoughUppercase, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        boolean isValid;

        if(password == null || password.isEmpty()){
            return false;
        } else {
            int uppercaseCount = 0;

            for(char ch : password.toCharArray()){
                if(Character.isUpperCase(ch)){
                    uppercaseCount++;
                }
            }
            isValid = uppercaseCount >= 1;
            return isValid;
        }

    }

    @Override
    public void initialize(NotEnoughUppercase constraintAnnotation) {
    }
}
