package org.example.xpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Atmosphere {

  private Map<String, Double> components = new HashMap();

  public void addComponent(String symbol, Double percentage){
    components.put(symbol, percentage);
  }
}
