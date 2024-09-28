package vn.minhtranq.sampleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gold/v1")
public class GoldController {

  @GetMapping
  public GoldRequestList getAllGold() {
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
