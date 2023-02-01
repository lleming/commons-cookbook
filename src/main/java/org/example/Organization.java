package org.example;

public class Organization {
  private String baseUrl;
  private Individual president;

  private String email;

  private Location address;

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Individual getPresident() {
    return president;
  }

  public void setPresident(Individual president) {
    this.president = president;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Location getAddress() {
    return address;
  }

  public void setAddress(Location address) {
    this.address = address;
  }
}
