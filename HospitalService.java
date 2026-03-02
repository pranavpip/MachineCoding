import java.util.*;
import java.util.stream.Collectors;

class HospitalService {
    private final DoctorRepository doctorRepo;
    public HospitalService(DoctorRepository repo) {
        this.doctorRepo = repo;
    }
    public void registerDoctor(String name, String spec) {
        doctorRepo.save(new Doctor(name, spec));
    }
    public void addAvailability(String docName, String time) {
        doctorRepo.findByName(docName).ifPresent(d -> d.addSlot(time));
    }
    public List<Doctor> getDoctorsBySpec(String spec) {
        return doctorRepo.findAll().stream()
            .filter(d -> d.getSpecialization().equalsIgnoreCase(spec))
            .collect(Collectors.toList());
    }
    public boolean bookAppointment(String docName, String time) {
        return doctorRepo.findByName(docName)
            .map(d -> {
                for (Slot s : d.getSlots()) {
                    if (s.getTime().equals(time) && !s.isBooked()) {
                        s.setBooked(true);
                        return true;
                    }
                }
                return false;
            }).orElse(false);
    }
}