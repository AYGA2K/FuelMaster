package ma.fstt.controller;

import ma.fstt.entity.Carburant;
import ma.fstt.repository.CarburantRepository;
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
@RequestMapping("/carburants")
public class CarburantController {

  @Autowired
  private CarburantRepository carburantRepository;

  @GetMapping
  public List<Carburant> getAllCarburants() {
    return carburantRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getCarburantById(@PathVariable Long id) {
    Optional<Carburant> carburant = carburantRepository.findById(id);
    if (carburant.isPresent()) {
      return ResponseEntity.ok(carburant.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<String> createCarburant(@RequestBody Carburant carburant) {
    System.out.println(carburant.getName());
    Carburant savedCarburant = carburantRepository.save(carburant);
    if (savedCarburant != null) {
      return ResponseEntity.ok("Carburant saved successfully");
    } else {
      return ResponseEntity.badRequest().body("Failed to save carburant");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCarburant(@PathVariable Long id, @RequestBody Carburant carburant) {
    if (carburantRepository.existsById(id)) {
      carburant.setId(id);
      carburantRepository.save(carburant);
      return ResponseEntity.ok("Carburant updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCarburant(@PathVariable Long id) {
    if (carburantRepository.existsById(id)) {
      carburantRepository.deleteById(id);
      return ResponseEntity.ok("Carburant deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
