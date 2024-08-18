package vn.minhtranq.sampleservice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import vn.minhtranq.sampleservice.validation.NumberValidation;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidation.class)
public @interface IsNumber {

  String message() default "Invalid number";
  Class<?>[] groups() default {};  // Include this line
  Class<? extends Payload>[] payload() default {};  // Include this line
}
