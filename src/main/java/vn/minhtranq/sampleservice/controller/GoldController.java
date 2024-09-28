package vn.minhtranq.sampleservice.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.minhtranq.sampleservice.model.request.GoldRequest;
import vn.minhtranq.sampleservice.model.response.GoldResponse;
import vn.minhtranq.sampleservice.model.response.GoldResponseList;
import vn.minhtranq.sampleservice.service.GoldService;

@RestController
@RequestMapping("/gold/v1")
public class GoldController {

  private GoldService goldService;

  @GetMapping
  public GoldResponseList getAllGold() {
    return goldService.getAllGold();
  }

  @GetMapping("/{id}")
  public ResponseEntity<GoldResponse> getGoldById(@PathVariable Long id) {
    GoldResponse goldResponse = goldService.getGoldById(id);
    if (goldResponse != null) {
      return ResponseEntity.ok(goldResponse);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<GoldResponse> createGold(@RequestBody GoldRequest goldRequest) {
    GoldResponse goldResponse = goldService.createGold(goldRequest);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(goldResponse.getId()).toUri();
    return ResponseEntity.created(location).body(goldResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<GoldResponse> updateGold(@PathVariable Long id, @RequestBody GoldRequest goldRequest) {
    GoldResponse goldResponse = goldService.updateGold(id, goldRequest);
    if (goldResponse != null) {
      return ResponseEntity.ok(goldResponse);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteGold(@PathVariable Long id) {
    goldService.deleteGold(id);
    return ResponseEntity.ok().build();
  }
}
