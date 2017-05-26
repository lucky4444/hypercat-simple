package com.lbram.data.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainsDescriptionValidator.class)
@Documented
public @interface ContainsDescription {
}
