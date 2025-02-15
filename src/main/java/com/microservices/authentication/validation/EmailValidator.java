package com.microservices.authentication.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.support.WebExchangeBindException;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_REGEX = "^(?=.*@)(?=.*\\.)[A-Za-z._%+-]{10,}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.trim().isEmpty() || !email.matches(EMAIL_REGEX)){
            FieldError fieldError = new FieldError(
                    "pathVariable",
                    "email",
                    email,
                    false,
                    new String[] {"Please enter a valid e-mail address"},
                    new Object[] {email},
                    "Please enter a valid e-mail address"
            );
            BindingResult bindingResult = new BeanPropertyBindingResult("pathVariable", "pathVariable");
            bindingResult.addError(fieldError);
            MethodParameter methodParameter = new MethodParameter(getClass().getDeclaredMethods()[0], 0);
            throw new WebExchangeBindException(methodParameter, bindingResult);
        }
        return true;
    }
}

