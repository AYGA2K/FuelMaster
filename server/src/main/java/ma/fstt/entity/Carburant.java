package ma.fstt.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carburants")
public class Carburant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // validate not null
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String description;
  @JsonBackReference
  @OneToMany(mappedBy = "carburant")
  private Set<Histocarb> histocarbs;

  public Carburant(Long id, String name, String description, Set<Histocarb> histocarbs) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.histocarbs = histocarbs;
  }

  public Carburant() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Set<Histocarb> getHistocarbs() {
    return histocarbs;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHistocarbs(Set<Histocarb> histocarbs) {
    this.histocarbs = histocarbs;
  }

}
