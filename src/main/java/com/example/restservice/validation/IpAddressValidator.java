package com.example.restservice.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IpAddressValidator implements ConstraintValidator<IpAddress, String> {
  @Override
  public void initialize(IpAddress constraintAnnotation) {
  }


  private static final String IPV4_REGEX =
          "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                  "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

  private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cvContext) {

    if (!(StringUtils.isBlank(value) || IPv4_PATTERN.matcher(value).matches())) {
      return false;
    }

    return true;
  }
}