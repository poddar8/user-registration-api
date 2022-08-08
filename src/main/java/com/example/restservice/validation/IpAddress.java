package com.example.restservice.validation;

import com.example.restservice.model.UserData;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Documented
@Constraint(validatedBy = IpAddressValidator.class)
public @interface IpAddress
{
  String message() default "{ipAddress.invalid}";
  Class<?>[] groups() default {};
  Class<? extends UserData>[] payload() default {};
}