package org.example;

public class Room {
    int area;
    boolean carpeted;
    boolean furnitured;

    public Room(){
        
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isCarpeted() {
        return carpeted;
    }

    public void setCarpeted(boolean carpeted) {
        this.carpeted = carpeted;
    }

    public boolean isFurnitured() {
        return furnitured;
    }

    public void setFurnitured(boolean furnitured) {
        this.furnitured = furnitured;
    }
    
}
