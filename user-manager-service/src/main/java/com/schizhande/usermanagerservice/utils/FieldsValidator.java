package com.schizhande.usermanagerservice.utils;

import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

public class FieldsValidator {
    public static <T> void validate(T t) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
}
