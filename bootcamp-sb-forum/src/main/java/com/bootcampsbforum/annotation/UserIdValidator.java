package com.bootcampsbforum.annotation;

import com.bootcampsbforum.dto.gov.request.UserIdRQDTO;
import com.bootcampsbforum.infra.RequestParamException;
import com.bootcampsbforum.infra.Syscode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserIdValidator
    implements ConstraintValidator<UserIdChecker, UserIdRQDTO> {

  @Override
  public boolean isValid(UserIdRQDTO dto, ConstraintValidatorContext context) {
    try {
      Integer i = Integer.valueOf(dto.getId());
      return i > 0;
    } catch (NumberFormatException e) { // catch with this exception
      throw new RequestParamException();
    }

  }
}
