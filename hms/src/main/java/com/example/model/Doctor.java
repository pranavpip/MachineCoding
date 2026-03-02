package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private List<Slot> slots = new ArrayList<>();
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public List<Slot> getSlots() { return slots; }
    public void addSlot(String time) { slots.add(new Slot(time)); }
}
