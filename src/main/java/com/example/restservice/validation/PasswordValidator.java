package com.example.restservice.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<PwdRule, String> {
  @Override
  public void initialize(PwdRule constraintAnnotation) {
  }


  private static final String PWD_REGEX =
          "^(?=.*[0-9])(?=.*[A-Z])(?=.*[_#$%]).{8,}$";

  private static final Pattern PWD_PATTERN = Pattern.compile(PWD_REGEX);

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cvContext) {

    if (!(StringUtils.isBlank(value) || PWD_PATTERN.matcher(value).matches())) {
      return false;
    }

    return true;
  }
}