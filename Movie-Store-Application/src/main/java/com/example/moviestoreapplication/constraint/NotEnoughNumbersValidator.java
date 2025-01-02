package com.example.moviestoreapplication.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEnoughNumbersValidator implements ConstraintValidator<NotEnoughNumbers, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        boolean isValid;

        if(password == null || password.isEmpty()){
            return true;
        } else {
            int numberCount = 0;

            for(char ch : password.toCharArray()){
                if(Character.isDigit(ch)){
                    numberCount++;
                }
            }
            isValid = numberCount >= 1;
            return isValid;
        }

    }

    @Override
    public void initialize(NotEnoughNumbers constraintAnnotation) {
    }
}

