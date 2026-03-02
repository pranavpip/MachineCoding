import java.util.*;

class DoctorRepository {
    private List<Doctor> doctors = new ArrayList<>();
    public void save(Doctor doctor) {
        doctors.add(doctor);
    }
    public List<Doctor> findAll() {
        return doctors;
    }
    public Optional<Doctor> findByName(String name) {
        return doctors.stream()
            .filter(d -> d.getName().equalsIgnoreCase(name))
            .findFirst();
    }
}