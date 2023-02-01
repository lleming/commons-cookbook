package org.example;

import java.util.Date;

public class Subscription {

  private Customer customer;
  private Magazine magazine;

  private Date endDate;

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Magazine getMagazine() {
    return magazine;
  }

  public void setMagazine(Magazine magazine) {
    this.magazine = magazine;
  }
}
