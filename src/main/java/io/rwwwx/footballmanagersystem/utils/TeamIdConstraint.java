package io.rwwwx.footballmanagersystem.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TeamIdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TeamIdConstraint {

    String message() default "Invalid team ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
