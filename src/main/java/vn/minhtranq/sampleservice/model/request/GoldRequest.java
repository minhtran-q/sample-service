package vn.minhtranq.sampleservice.model.request;

import lombok.Data;
import vn.minhtranq.sampleservice.validation.annotation.IsNumber;

@Data
public class GoldRequest {

  @IsNumber
  private String value;

}
