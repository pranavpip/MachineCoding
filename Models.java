import java.util.*;
class Slot {
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

class Doctor {
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