package vn.minhtranq.sampleservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.math.NumberUtils;
import vn.minhtranq.sampleservice.validation.annotation.IsNumber;

public class NumberValidation implements ConstraintValidator<IsNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return NumberUtils.isParsable(value);
  }
}
