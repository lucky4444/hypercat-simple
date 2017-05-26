package com.lbram.data.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainsDescriptionValidator.class)
public @interface ContainsDescription {
    String message() default "{com.lbram.validation.constraints.description_missing}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
