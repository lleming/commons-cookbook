package org.example.xpath;

import java.util.ArrayList;
import java.util.List;

public class Team {

  private Person coach;
  private List players = new ArrayList();

  public Person getCoach() {
    return coach;
  }

  public void setCoach(Person coach) {
    this.coach = coach;
  }

  public List getPlayers() {
    return players;
  }

  public void setPlayers(List players) {
    this.players = players;
  }
}
