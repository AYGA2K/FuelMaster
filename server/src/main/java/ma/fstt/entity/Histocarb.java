package ma.fstt.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Histocarb
 */
@Entity
@Table(name = "histocarbs")
public class Histocarb {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private double price;
  private Date date;

  // @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "station_id")
  Station station;

  // @JsonManagedReference
  @ManyToOne
  @JoinColumn(name = "carburant_id")
  Carburant carburant;

  public Histocarb(Long id, double price, Date date, Station station, Carburant carburant) {
    this.id = id;
    this.price = price;
    this.date = date;
    this.station = station;
    this.carburant = carburant;
  }

  public Histocarb() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Station getStation() {
    return station;
  }

  public void setStation(Station station) {
    this.station = station;
  }

  public Carburant getCarburant() {
    return carburant;
  }

  public void setCarburant(Carburant carburant) {
    this.carburant = carburant;
  }

}
