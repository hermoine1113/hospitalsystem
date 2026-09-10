package in.kmit.hospital;

import in.kmit.hospital.model.Doctor;
import in.kmit.hospital.model.Patient;
import in.kmit.hospital.service.AppointmentService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();
        service.addPatient(new Patient(101, "Anita", "9876543210"));
        service.addDoctor(new Doctor(201, "Rao", "Cardiology"));

        service.bookAppointment(101, 201, LocalDateTime.now().plusDays(1));
        System.out.println("Hospital Appointment Management System");
        service.getAppointments().forEach(System.out::println);
    }
}
