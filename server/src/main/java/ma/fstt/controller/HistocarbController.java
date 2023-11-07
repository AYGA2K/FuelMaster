package ma.fstt.controller;

import ma.fstt.entity.Histocarb;
import ma.fstt.repository.HistocarbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/histocarbs")
public class HistocarbController {

  @Autowired
  private HistocarbRepository histocarbRepository;

  @GetMapping
  public List<Histocarb> getAllHistocarbs() {
    return histocarbRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getHistocarbById(@PathVariable Long id) {
    Optional<Histocarb> histocarb = histocarbRepository.findById(id);
    if (histocarb.isPresent()) {
      return ResponseEntity.ok(histocarb.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<String> createHistocarb(@RequestBody Histocarb histocarb) {
    Histocarb savedHistocarb = histocarbRepository.save(histocarb);
    if (savedHistocarb != null) {
      return ResponseEntity.ok("Histocarb saved successfully");
    } else {
      return ResponseEntity.badRequest().body("Failed to save histocarb");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateHistocarb(@PathVariable Long id, @RequestBody Histocarb histocarb) {
    if (histocarbRepository.existsById(id)) {
      histocarb.setId(id);
      histocarbRepository.save(histocarb);
      return ResponseEntity.ok("Histocarb updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteHistocarb(@PathVariable Long id) {
    if (histocarbRepository.existsById(id)) {
      histocarbRepository.deleteById(id);
      return ResponseEntity.ok("Histocarb deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
