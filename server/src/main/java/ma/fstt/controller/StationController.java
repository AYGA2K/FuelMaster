package ma.fstt.controller;

import java.util.List;
import java.util.Optional;

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

import ma.fstt.entity.Station;
import ma.fstt.repository.StationRepository;

@RestController
@RequestMapping("/stations")

public class StationController {

  @Autowired
  private StationRepository stationRepository;

  @GetMapping
  public List<Station> getAllStations() {
    return stationRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getStationById(@PathVariable Long id) {
    Optional<Station> station = stationRepository.findById(id);
    if (station.isPresent()) {
      return ResponseEntity.ok(station.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<String> createStation(@RequestBody Station station) {
    Station savedStation = stationRepository.save(station);
    if (savedStation != null) {
      return ResponseEntity.ok("Station saved successfully");
    } else {
      return ResponseEntity.badRequest().body("Failed to save station");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateStation(@PathVariable Long id, @RequestBody Station station) {
    if (stationRepository.existsById(id)) {
      station.setId(id);
      stationRepository.save(station);
      return ResponseEntity.ok("Station updated successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStation(@PathVariable Long id) {
    if (stationRepository.existsById(id)) {
      stationRepository.deleteById(id);
      return ResponseEntity.ok("Station deleted successfully");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
