package ma.fstt.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Station
 */
@Entity
@Table(name = "stations")
public class Station {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String city;
  private String address;
  @JsonBackReference
  @OneToMany(mappedBy = "station")
  private Set<Histocarb> histocarbs;

  public Station(Long id, String name, String city, String address, Set<Histocarb> histocarbs) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.address = address;
    this.histocarbs = histocarbs;
  }

  public Station() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Set<Histocarb> getHistocarbs() {
    return histocarbs;
  }

  public void setHistocarbs(Set<Histocarb> histocarbs) {
    this.histocarbs = histocarbs;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
