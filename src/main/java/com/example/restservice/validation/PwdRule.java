package com.example.restservice.validation;

import com.example.restservice.model.UserData;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = PasswordValidator.class)
public @interface PwdRule
{
  String message() default "{Password.invalid}";
  Class<?>[] groups() default {};
  Class<? extends UserData>[] payload() default {};
}