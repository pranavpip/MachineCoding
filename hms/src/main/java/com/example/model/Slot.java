package com.example.model;

public class Slot {
    private String time;
    private boolean isBooked;
    public Slot(String time) {
        this.time = time;
        this.isBooked = false;
    }
    public String getTime() { return time; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }
}
