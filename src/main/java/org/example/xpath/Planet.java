package org.example.xpath;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Planet {

  private String name;
  private BigDecimal mass;
  private Double radius;
  private Orbit orbit;
  private Atmosphere atmosphere;
  private List moons = new ArrayList();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getMass() {
    return mass;
  }

  public void setMass(BigDecimal mass) {
    this.mass = mass;
  }

  public Double getRadius() {
    return radius;
  }

  public void setRadius(Double radius) {
    this.radius = radius;
  }

  public List getMoons() {
    return moons;
  }

  public void setMoons(List moons) {
    this.moons = moons;
  }

  public void addMoon(String moon) {
    this.moons.add(moon);
  }

  public Atmosphere getAtmosphere() {
    return atmosphere;
  }

  public void setAtmosphere(Atmosphere atmosphere) {
    this.atmosphere = atmosphere;
  }

  public Orbit getOrbit() {
    return orbit;
  }

  public void setOrbit(Orbit orbit) {
    this.orbit = orbit;
  }
}
