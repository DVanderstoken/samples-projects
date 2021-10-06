package fr.dva.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValidDateValidator.class)
@Target({ ElementType.FIELD })
@Retention(RUNTIME)
@Documented
public @interface ValidISBN {
    String message() default "Provided ISBN number is not valid";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}