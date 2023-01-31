package org.example;

import java.util.HashMap;
import java.util.Map;

public class Region {
        String name;
        Map cities = new HashMap();
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Map getCities() {
            return cities;
        }
        public void setCities(Map cities) {
            this.cities = cities;
        }


}
