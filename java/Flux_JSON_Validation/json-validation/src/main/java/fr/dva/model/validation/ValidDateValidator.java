package fr.dva.model.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidDateValidator implements ConstraintValidator<ValidDate, Object[]> {
    @Override
    public boolean isValid(Object[] values, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (values[0] != null) {
            try {
                LocalDate.parse((CharSequence) values[0], DateTimeFormatter.ofPattern("uuuuMMdd").withResolverStyle(ResolverStyle.STRICT));
            } catch (DateTimeParseException dtpe) {
                result = false;
            }
        }
        return result;
    }
}

