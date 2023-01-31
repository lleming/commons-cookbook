package org.example;

import java.util.Date;

public class Patient {
    String name;
    int severenity;
    Date checkIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverenity() {
        return severenity;
    }

    public void setSeverenity(int severenity) {
        this.severenity = severenity;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + ", severenity=" + severenity + ", checkIn=" + checkIn + "]";
    }
}
