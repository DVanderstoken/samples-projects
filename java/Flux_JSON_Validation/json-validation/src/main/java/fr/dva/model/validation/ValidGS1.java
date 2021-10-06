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
public @interface ValidGS1 {
    String message() default "Provided GS1 code is not valid";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}
