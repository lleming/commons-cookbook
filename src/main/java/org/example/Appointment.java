package org.example;

import java.util.Date;

public class Appointment {

  private Long id;

  private Individual volunteer;
  private Location location;
  private Organization organization;

  private Date startTime;
  private Date endTime;

  private Date date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Individual getVolunteer() {
    return volunteer;
  }

  public void setVolunteer(Individual volunteer) {
    this.volunteer = volunteer;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
