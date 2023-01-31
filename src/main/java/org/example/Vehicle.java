package org.example;

public class Vehicle {
    String make;
    String model;
    int year;
    Engine engine;
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public String toString() {
        return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + ", engine=" + engine + "]";
    }

    
}
