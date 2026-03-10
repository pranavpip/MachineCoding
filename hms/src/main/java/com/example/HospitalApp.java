package com.example;
import com.example.model.Doctor;
import com.example.repo.DoctorRepository;
import com.example.services.HospitalService;
import java.util.*;

public class HospitalApp {
    public void run() {
        DoctorRepository repo = new DoctorRepository();
        HospitalService service = new HospitalService(repo);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- HMS Menu ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. Add Availability");
            System.out.println("3. Search & Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Specialization: ");
                String spec = scanner.nextLine();
                service.registerDoctor(name, spec);
                System.out.println("Doctor Registered!");
            } else if (choice == 2) {
                System.out.print("Doctor Name: ");
                String name = scanner.nextLine();
                System.out.print("Time (HH:mm): ");
                String time = scanner.nextLine();
                service.addAvailability(name, time);
                System.out.println("Slot Added!");
            } else if (choice == 3) {
                System.out.print("Specialization to search: ");
                String spec = scanner.nextLine();
                List<Doctor> docs = service.getDoctorsBySpec(spec);
                if (docs.isEmpty()) {
                    System.out.println("No doctors found.");
                } else {
                    docs.forEach(d -> System.out.println("- " + d.getName()));
                    System.out.print("Enter Doctor Name to book: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter Time: ");
                    String time = scanner.nextLine();
                    boolean ok = service.bookAppointment(dName, time);
                    System.out.println(ok ? "Booking Confirmed!" : "Booking Failed!");
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}