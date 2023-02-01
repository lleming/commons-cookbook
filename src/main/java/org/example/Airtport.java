package org.example;

public class Airtport {

  private final int id;
  private final String code;
  private final String name;
  private final int passengers;
  private final String countryCode;

  public Airtport(int id, String code, String name, int passengers, String countryCode) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.passengers = passengers;
    this.countryCode = countryCode;
  }

  public int getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public int getPassengers() {
    return passengers;
  }

  public String getCountryCode() {
    return countryCode;
  }
}
