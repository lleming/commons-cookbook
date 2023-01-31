package org.example;

public class Engine {
    Integer milesGalon;
    Integer percentElectric;
    public int getMilesGalon() {
        return milesGalon;
    }
    public void setMilesGalon(int milesGalon) {
        this.milesGalon = milesGalon;
    }
    public int getPercentElectric() {
        return percentElectric;
    }
    public void setPercentElectric(int percentElectric) {
        this.percentElectric = percentElectric;
    }
    @Override
    public String toString() {
        return "Engine [milesGalon=" + milesGalon + ", percentElectric=" + percentElectric + "]";
    }

    
}
