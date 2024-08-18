package vn.minhtranq.sampleservice.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.minhtranq.sampleservice.model.request.GoldRequest;

@RestController
public class GoldController {

  @PostMapping("/test")
  public void test(@RequestBody @Valid GoldRequest goldRequest) {
    // do something
  }
}
